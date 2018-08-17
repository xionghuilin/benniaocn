/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 服务优势Entity
 * @author xionghl
 * @version 2018-06-25
 */
public class ServiceAdvantage extends DataEntity<ServiceAdvantage> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String preImage;
	
	public ServiceAdvantage() {
		super();
	}

	public ServiceAdvantage(String id){
		super(id);
	}

	@Length(min=1, max=255, message="标题长度必须介于 1 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreImage() {
		return preImage;
	}

	public void setPreImage(String preImage) {
		this.preImage = preImage;
	}
}