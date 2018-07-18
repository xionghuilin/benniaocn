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
import com.thinkgem.jeesite.modules.cms.entity.MainProduct;
import com.thinkgem.jeesite.modules.cms.service.MainProductService;

/**
 * 主打产品Controller
 * @author xionghl
 * @version 2018-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/mainProduct")
public class MainProductController extends BaseController {

	@Autowired
	private MainProductService mainProductService;
	
	@ModelAttribute
	public MainProduct get(@RequestParam(required=false) String id) {
		MainProduct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = mainProductService.get(id);
		}
		if (entity == null){
			entity = new MainProduct();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:mainProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(MainProduct mainProduct, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MainProduct> page = mainProductService.findPage(new Page<MainProduct>(request, response), mainProduct); 
		model.addAttribute("page", page);
		return "modules/cms/mainProductList";
	}

	@RequiresPermissions("cms:mainProduct:view")
	@RequestMapping(value = "form")
	public String form(MainProduct mainProduct, Model model) {
		model.addAttribute("mainProduct", mainProduct);
		return "modules/cms/mainProductForm";
	}

	@RequiresPermissions("cms:mainProduct:edit")
	@RequestMapping(value = "save")
	public String save(MainProduct mainProduct, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, mainProduct)){
			return form(mainProduct, model);
		}
		mainProductService.save(mainProduct);
		addMessage(redirectAttributes, "保存主打产品成功");
		return "redirect:"+Global.getAdminPath()+"/cms/mainProduct/?repage";
	}
	
	@RequiresPermissions("cms:mainProduct:edit")
	@RequestMapping(value = "delete")
	public String delete(MainProduct mainProduct, RedirectAttributes redirectAttributes) {
		mainProductService.delete(mainProduct);
		addMessage(redirectAttributes, "删除主打产品成功");
		return "redirect:"+Global.getAdminPath()+"/cms/mainProduct/?repage";
	}

}