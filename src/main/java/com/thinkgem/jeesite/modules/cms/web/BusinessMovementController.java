/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.BusinessMovement;
import com.thinkgem.jeesite.modules.cms.service.BusinessMovementService;

/**
 * 企业动态Controller
 * @author xionghl
 * @version 2018-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/businessMovement")
public class BusinessMovementController extends BaseController {

	@Autowired
	private BusinessMovementService businessMovementService;
	
	@ModelAttribute
	public BusinessMovement get(@RequestParam(required=false) String id) {
		BusinessMovement entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = businessMovementService.get(id);
		}
		if (entity == null){
			entity = new BusinessMovement();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:businessMovement:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusinessMovement businessMovement, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BusinessMovement> page = businessMovementService.findPage(new Page<BusinessMovement>(request, response), businessMovement); 
		model.addAttribute("page", page);
		return "modules/cms/businessMovementList";
	}

	@RequiresPermissions("cms:businessMovement:view")
	@RequestMapping(value = "form")
	public String form(BusinessMovement businessMovement, Model model) {
		model.addAttribute("businessMovement", businessMovement);
		return "modules/cms/businessMovementForm";
	}

	@RequiresPermissions("cms:businessMovement:edit")
	@RequestMapping(value = "save")
	public String save(BusinessMovement businessMovement, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, businessMovement)){
			return form(businessMovement, model);
		}
		businessMovementService.save(businessMovement);
		addMessage(redirectAttributes, "保存企业动态成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessMovement/?repage";
	}
	
	@RequiresPermissions("cms:businessMovement:edit")
	@RequestMapping(value = "delete")
	public String delete(BusinessMovement businessMovement, RedirectAttributes redirectAttributes) {
		businessMovementService.delete(businessMovement);
		addMessage(redirectAttributes, "删除企业动态成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessMovement/?repage";
	}

}