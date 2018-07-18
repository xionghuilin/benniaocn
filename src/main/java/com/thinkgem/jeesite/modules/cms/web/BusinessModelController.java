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
import com.thinkgem.jeesite.modules.cms.entity.BusinessModel;
import com.thinkgem.jeesite.modules.cms.service.BusinessModelService;

/**
 * 经营模式Controller
 * @author xionghl
 * @version 2018-07-16
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/businessModel")
public class BusinessModelController extends BaseController {

	@Autowired
	private BusinessModelService businessModelService;
	
	@ModelAttribute
	public BusinessModel get(@RequestParam(required=false) String id) {
		BusinessModel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = businessModelService.get(id);
		}
		if (entity == null){
			entity = new BusinessModel();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:businessModel:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusinessModel businessModel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BusinessModel> page = businessModelService.findPage(new Page<BusinessModel>(request, response), businessModel); 
		model.addAttribute("page", page);
		return "modules/cms/businessModelList";
	}

	@RequiresPermissions("cms:businessModel:view")
	@RequestMapping(value = "form")
	public String form(BusinessModel businessModel, Model model) {
		model.addAttribute("businessModel", businessModel);
		return "modules/cms/businessModelForm";
	}

	@RequiresPermissions("cms:businessModel:edit")
	@RequestMapping(value = "save")
	public String save(BusinessModel businessModel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, businessModel)){
			return form(businessModel, model);
		}
		businessModelService.save(businessModel);
		addMessage(redirectAttributes, "保存经营模式成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessModel/?repage";
	}
	
	@RequiresPermissions("cms:businessModel:edit")
	@RequestMapping(value = "delete")
	public String delete(BusinessModel businessModel, RedirectAttributes redirectAttributes) {
		businessModelService.delete(businessModel);
		addMessage(redirectAttributes, "删除经营模式成功");
		return "redirect:"+Global.getAdminPath()+"/cms/businessModel/?repage";
	}

}