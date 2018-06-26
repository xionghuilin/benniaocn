/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 合作伙伴Entity
 * @author xionghl
 * @version 2018-06-25
 */
public class Partner extends DataEntity<Partner> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 公司名称
	private String link;		// 公司href
	private String logo;		// 合作伙伴logo
	
	public Partner() {
		super();
	}

	public Partner(String id){
		super(id);
	}

	@Length(min=1, max=255, message="公司名称长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="公司href长度必须介于 0 和 255 之间")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Length(min=0, max=255, message="合作伙伴logo长度必须介于 0 和 255 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}