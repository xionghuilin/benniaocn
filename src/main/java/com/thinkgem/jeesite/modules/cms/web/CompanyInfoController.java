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
import com.thinkgem.jeesite.modules.cms.entity.CompanyInfo;
import com.thinkgem.jeesite.modules.cms.service.CompanyInfoService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 公司信息Controller
 * @author xionghl
 * @version 2018-06-23
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/companyInfo")
public class CompanyInfoController extends BaseController {

	@Autowired
	private CompanyInfoService companyInfoService;
	
	@ModelAttribute
	public CompanyInfo get(@RequestParam(required=false) String id) {
		CompanyInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = companyInfoService.get(id);
		}
		if (entity == null){
			entity = new CompanyInfo();
		}
		return entity;
	}


	/**
	 * 公司信息显示及保存
	 * @param companyInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "info")
	public String info(CompanyInfo companyInfo, HttpServletResponse response, Model model) {
		if (StringUtils.isNotBlank(companyInfo.getName())){
			companyInfoService.save(companyInfo);
			model.addAttribute("message", "保存公司信息成功");
		}
		model.addAttribute("companyInfo", companyInfo);
		return "modules/cms/companyInfoForm";
	}

	@RequiresPermissions("cms:companyInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(CompanyInfo companyInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CompanyInfo> page = companyInfoService.findPage(new Page<CompanyInfo>(request, response), companyInfo);
		model.addAttribute("page", page);
		return "modules/cms/companyInfoList";
	}

	@RequiresPermissions("cms:companyInfo:view")
	@RequestMapping(value = "form")
	public String form(CompanyInfo companyInfo, Model model) {
		model.addAttribute("companyInfo", companyInfo);
		return "modules/cms/companyInfoForm";
	}

	@RequiresPermissions("cms:companyInfo:edit")
	@RequestMapping(value = "save")
	public String save(CompanyInfo companyInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, companyInfo)){
			return form(companyInfo, model);
		}
		companyInfoService.save(companyInfo);
		addMessage(redirectAttributes, "保存公司信息成功");
		return "redirect:"+Global.getAdminPath()+"/cms/companyInfo/?repage";
	}

	@RequiresPermissions("cms:companyInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(CompanyInfo companyInfo, RedirectAttributes redirectAttributes) {
		companyInfoService.delete(companyInfo);
		addMessage(redirectAttributes, "删除公司信息成功");
		return "redirect:"+Global.getAdminPath()+"/cms/companyInfo/?repage";
	}

}