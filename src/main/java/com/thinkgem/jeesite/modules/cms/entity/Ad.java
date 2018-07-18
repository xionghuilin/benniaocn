/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 广告设置Entity
 * @author xionghl
 * @version 2018-07-03
 */
public class Ad extends DataEntity<Ad> {
	
	private static final long serialVersionUID = 1L;
	private String image;		// 图片地址
	private String title;		// 标题
	private String url;		// 链接
	private String content;		// 广告内容
	private String status;		// 在线状态
	private String type;		// 广告类型
	
	public Ad() {
		super();
	}

	public Ad(String id){
		super(id);
	}

	@Length(min=1, max=255, message="图片地址长度必须介于 1 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Length(min=1, max=64, message="标题长度必须介于 1 和 64 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="链接长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=255, message="广告内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=1, message="在线状态长度必须介于 0 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=1, max=1, message="广告类型长度必须介于 1 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 广告类型（0：轮播广告；1：横幅广告；）
	 */
	public static final String TYPE_CAROUSEL = "0";
	public static final String TYPE_BANNER = "1";
	
}