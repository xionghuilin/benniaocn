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
import com.thinkgem.jeesite.modules.cms.entity.Process;
import com.thinkgem.jeesite.modules.cms.service.ProcessService;

/**
 * 服务流程Controller
 * @author xionghl
 * @version 2018-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/process")
public class ProcessController extends BaseController {

	@Autowired
	private ProcessService processService;
	
	@ModelAttribute
	public Process get(@RequestParam(required=false) String id) {
		Process entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = processService.get(id);
		}
		if (entity == null){
			entity = new Process();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:process:view")
	@RequestMapping(value = {"list", ""})
	public String list(Process process, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Process> page = processService.findPage(new Page<Process>(request, response), process); 
		model.addAttribute("page", page);
		return "modules/cms/processList";
	}

	@RequiresPermissions("cms:process:view")
	@RequestMapping(value = "form")
	public String form(Process process, Model model) {
		model.addAttribute("process", process);
		return "modules/cms/processForm";
	}

	@RequiresPermissions("cms:process:edit")
	@RequestMapping(value = "save")
	public String save(Process process, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, process)){
			return form(process, model);
		}
		processService.save(process);
		addMessage(redirectAttributes, "保存服务流程成功");
		return "redirect:"+Global.getAdminPath()+"/cms/process/?repage";
	}
	
	@RequiresPermissions("cms:process:edit")
	@RequestMapping(value = "delete")
	public String delete(Process process, RedirectAttributes redirectAttributes) {
		processService.delete(process);
		addMessage(redirectAttributes, "删除服务流程成功");
		return "redirect:"+Global.getAdminPath()+"/cms/process/?repage";
	}

}