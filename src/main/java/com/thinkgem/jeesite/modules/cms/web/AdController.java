/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import java.util.List;

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
import com.thinkgem.jeesite.modules.cms.entity.Ad;
import com.thinkgem.jeesite.modules.cms.service.AdService;

/**
 * 广告设置Controller
 * @author xionghl
 * @version 2018-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/ad")
public class AdController extends BaseController {

	@Autowired
	private AdService adService;
	
	@ModelAttribute
	public Ad get(@RequestParam(required=false) String id) {
		Ad entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = adService.get(id);
		}
		if (entity == null){
			entity = new Ad();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:ad:view")
	@RequestMapping(value = {"list", ""})
	public String list(Ad ad, HttpServletRequest request, HttpServletResponse response, Model model) {
		// 获取轮播广告图片
		ad.setType(Ad.TYPE_CAROUSEL);
		Page<Ad> page = adService.findPage(new Page<Ad>(request, response), ad); 
		model.addAttribute("page", page);
		return "modules/cms/adList";
	}

	@RequiresPermissions("cms:ad:view")
	@RequestMapping(value = "banner")
	public String banner(Ad ad, Model model) {
		ad.setType(Ad.TYPE_BANNER);
		List<Ad> adList = adService.findList(ad);
		model.addAttribute("ad", adList.get(0));
		return "modules/cms/adBannerForm";
	}

	@RequiresPermissions("cms:ad:view")
	@RequestMapping(value = "form")
	public String form(Ad ad, Model model) {
		model.addAttribute("ad", ad);
		return "modules/cms/adForm";
	}

	@RequiresPermissions("cms:ad:edit")
	@RequestMapping(value = "save")
	public String save(Ad ad, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ad)){
			return form(ad, model);
		}
		adService.save(ad);
		String redirect = null;
		if(Ad.TYPE_CAROUSEL.equalsIgnoreCase(ad.getType())){
			addMessage(redirectAttributes, "保存轮播广告成功");
			redirect = "redirect:"+Global.getAdminPath()+"/cms/ad/?repage";
		}else{
			addMessage(redirectAttributes, "保存横幅广告成功");
			redirect = "redirect:"+Global.getAdminPath()+"/cms/ad/banner?repage";
		}

		return redirect;
	}
	
	@RequiresPermissions("cms:ad:edit")
	@RequestMapping(value = "delete")
	public String delete(Ad ad, RedirectAttributes redirectAttributes) {
		adService.delete(ad);
		addMessage(redirectAttributes, "删除轮播广告成功");
		return "redirect:"+Global.getAdminPath()+"/cms/ad/?repage";
	}

}