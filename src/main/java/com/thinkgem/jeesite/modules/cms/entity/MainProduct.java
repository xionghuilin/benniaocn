/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 主打产品Entity
 * @author xionghl
 * @version 2018-07-03
 */
public class MainProduct extends DataEntity<MainProduct> {
	
	private static final long serialVersionUID = 1L;
	private String image;		// 图片
	private String titleZh;		// 中文标题
	private String titleUs;		// 英文标题
	private String intro;		// 简介信息
	
	public MainProduct() {
		super();
	}

	public MainProduct(String id){
		super(id);
	}

	@Length(min=0, max=255, message="图片长度必须介于 0 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Length(min=0, max=64, message="中文标题长度必须介于 0 和 64 之间")
	public String getTitleZh() {
		return titleZh;
	}

	public void setTitleZh(String titleZh) {
		this.titleZh = titleZh;
	}
	
	@Length(min=0, max=64, message="英文标题长度必须介于 0 和 64 之间")
	public String getTitleUs() {
		return titleUs;
	}

	public void setTitleUs(String titleUs) {
		this.titleUs = titleUs;
	}
	
	@Length(min=0, max=255, message="简介信息长度必须介于 0 和 255 之间")
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}