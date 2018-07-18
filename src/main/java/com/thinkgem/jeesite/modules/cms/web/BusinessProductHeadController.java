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
import com.thinkgem.jeesite.modules.cms.entity.BusinessProductHead;
import com.thinkgem.jeesite.modules.cms.service.BusinessProductHeadService;

/**
 * 经营产品Controller
 * @author xionghl
 * @version 2018-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/businessProductHead")
public class BusinessProductHeadController extends BaseController {

	@Autowired
	private BusinessProductHeadService businessProductHeadService;
	
	@ModelAttribute
	public BusinessProductHead get(@RequestParam(required=false) String id) {
		BusinessProductHead entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = businessProductHeadService.get(id);
		}
		if (entity == null){
			entity = new BusinessProductHead();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:businessProductHead:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusinessProductHead businessProductHead, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BusinessProductHead> page = businessProductHeadService.findPage(new Page<BusinessProductHead>(request, response), businessProductHead); 
		model.addAttribute("page", page);
		return "modules/cms/businessProductHeadList";
	}

	@RequiresPermissions("cms:businessProductHead:view")
	@RequestMapping(value = "form")
	public String form(BusinessProductHead businessProductHead, Model model) {
		model.addAttribute("businessProductHead", businessProductHead);
		return "modules/cms/businessProductHeadForm";
	}

	@RequiresPermissions("cms:businessProductHead:edit")
	@RequestMapping(value = "save")
	public String save(BusinessProductHead businessProductHead, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, businessProductHead)){
			return form(businessProductHead, model);
		}
		businessProductHeadService.save(businessProductHead);
		addMessage(redirectAttributes, "保存经营产品成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessProductHead/?repage";
	}
	
	@RequiresPermissions("cms:businessProductHead:edit")
	@RequestMapping(value = "delete")
	public String delete(BusinessProductHead businessProductHead, RedirectAttributes redirectAttributes) {
		businessProductHeadService.delete(businessProductHead);
		addMessage(redirectAttributes, "删除经营产品成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessProductHead/?repage";
	}

}