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
import com.thinkgem.jeesite.modules.cms.entity.ProductCase;
import com.thinkgem.jeesite.modules.cms.service.ProductCaseService;

/**
 * 产品案例Controller
 * @author xionghl
 * @version 2018-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/productCase")
public class ProductCaseController extends BaseController {

	@Autowired
	private ProductCaseService productCaseService;
	
	@ModelAttribute
	public ProductCase get(@RequestParam(required=false) String id) {
		ProductCase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productCaseService.get(id);
		}
		if (entity == null){
			entity = new ProductCase();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:productCase:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductCase productCase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductCase> page = productCaseService.findPage(new Page<ProductCase>(request, response), productCase); 
		model.addAttribute("page", page);
		return "modules/cms/productCaseList";
	}

	@RequiresPermissions("cms:productCase:view")
	@RequestMapping(value = "form")
	public String form(ProductCase productCase, Model model) {
		model.addAttribute("productCase", productCase);
		return "modules/cms/productCaseForm";
	}

	@RequiresPermissions("cms:productCase:edit")
	@RequestMapping(value = "save")
	public String save(ProductCase productCase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productCase)){
			return form(productCase, model);
		}
		productCaseService.save(productCase);
		addMessage(redirectAttributes, "保存产品案例成功");
		return "redirect:"+Global.getAdminPath()+"/cms/productCase/?repage";
	}
	
	@RequiresPermissions("cms:productCase:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductCase productCase, RedirectAttributes redirectAttributes) {
		productCaseService.delete(productCase);
		addMessage(redirectAttributes, "删除产品案例成功");
		return "redirect:"+Global.getAdminPath()+"/cms/productCase/?repage";
	}

}