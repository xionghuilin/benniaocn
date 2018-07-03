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
import com.thinkgem.jeesite.modules.cms.entity.Position;
import com.thinkgem.jeesite.modules.cms.service.PositionService;

/**
 * 招聘信息Controller
 * @author xionghl
 * @version 2018-06-29
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/position")
public class PositionController extends BaseController {

	@Autowired
	private PositionService positionService;
	
	@ModelAttribute
	public Position get(@RequestParam(required=false) String id) {
		Position entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = positionService.get(id);
		}
		if (entity == null){
			entity = new Position();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:position:view")
	@RequestMapping(value = {"list", ""})
	public String list(Position position, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Position> page = positionService.findPage(new Page<Position>(request, response), position); 
		model.addAttribute("page", page);
		return "modules/cms/positionList";
	}

	@RequiresPermissions("cms:position:view")
	@RequestMapping(value = "form")
	public String form(Position position, Model model) {
		model.addAttribute("position", position);
		return "modules/cms/positionForm";
	}

	@RequiresPermissions("cms:position:edit")
	@RequestMapping(value = "save")
	public String save(Position position, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, position)){
			return form(position, model);
		}
		positionService.save(position);
		addMessage(redirectAttributes, "保存招聘信息成功");
		return "redirect:"+Global.getAdminPath()+"/cms/position/?repage";
	}
	
	@RequiresPermissions("cms:position:edit")
	@RequestMapping(value = "delete")
	public String delete(Position position, RedirectAttributes redirectAttributes) {
		positionService.delete(position);
		addMessage(redirectAttributes, "删除招聘信息成功");
		return "redirect:"+Global.getAdminPath()+"/cms/position/?repage";
	}

}