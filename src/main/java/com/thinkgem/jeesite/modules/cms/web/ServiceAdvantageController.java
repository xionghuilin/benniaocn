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
import com.thinkgem.jeesite.modules.cms.entity.ServiceAdvantage;
import com.thinkgem.jeesite.modules.cms.service.ServiceAdvantageService;

/**
 * 服务优势Controller
 * @author xionghl
 * @version 2018-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/serviceAdvantage")
public class ServiceAdvantageController extends BaseController {

	@Autowired
	private ServiceAdvantageService serviceAdvantageService;
	
	@ModelAttribute
	public ServiceAdvantage get(@RequestParam(required=false) String id) {
		ServiceAdvantage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = serviceAdvantageService.get(id);
		}
		if (entity == null){
			entity = new ServiceAdvantage();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:serviceAdvantage:view")
	@RequestMapping(value = {"list", ""})
	public String list(ServiceAdvantage serviceAdvantage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceAdvantage> page = serviceAdvantageService.findPage(new Page<ServiceAdvantage>(request, response), serviceAdvantage); 
		model.addAttribute("page", page);
		return "modules/cms/serviceAdvantageList";
	}

	@RequiresPermissions("cms:serviceAdvantage:view")
	@RequestMapping(value = "form")
	public String form(ServiceAdvantage serviceAdvantage, Model model) {
		model.addAttribute("serviceAdvantage", serviceAdvantage);
		return "modules/cms/serviceAdvantageForm";
	}

	@RequiresPermissions("cms:serviceAdvantage:edit")
	@RequestMapping(value = "save")
	public String save(ServiceAdvantage serviceAdvantage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, serviceAdvantage)){
			return form(serviceAdvantage, model);
		}
		serviceAdvantageService.save(serviceAdvantage);
		addMessage(redirectAttributes, "保存服务优势成功");
		return "redirect:"+Global.getAdminPath()+"/cms/serviceAdvantage/?repage";
	}
	
	@RequiresPermissions("cms:serviceAdvantage:edit")
	@RequestMapping(value = "delete")
	public String delete(ServiceAdvantage serviceAdvantage, RedirectAttributes redirectAttributes) {
		serviceAdvantageService.delete(serviceAdvantage);
		addMessage(redirectAttributes, "删除服务优势成功");
		return "redirect:"+Global.getAdminPath()+"/cms/serviceAdvantage/?repage";
	}

}