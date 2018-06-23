/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 公司信息Entity
 * @author xionghl
 * @version 2018-06-23
 */
public class CompanyInfo extends DataEntity<CompanyInfo> {
	
	private static final long serialVersionUID = 1L;
	private String logo;		// 公司logo
	private String name;		// 公司名称
	private String shortName;		// 公司简称
	private String website;		// 公司网站
	private String shop;		// 商城
	private String description;		// 简介
	private String address;		// 地址
	private String post;		// 邮编
	private String tel;		// 电话
	private String fax;		// 传真
	private String mail;		// 邮箱
	private String map;		// 地图
	
	public CompanyInfo() {
		super();
	}

	public CompanyInfo(String id){
		super(id);
	}

	@Length(min=0, max=255, message="公司logo长度必须介于 0 和 255 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Length(min=0, max=255, message="公司名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="公司简称长度必须介于 0 和 255 之间")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@Length(min=0, max=255, message="公司网站长度必须介于 0 和 255 之间")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Length(min=0, max=255, message="商城长度必须介于 0 和 255 之间")
	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=255, message="地址长度必须介于 0 和 255 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=64, message="邮编长度必须介于 0 和 64 之间")
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	@Length(min=0, max=64, message="电话长度必须介于 0 和 64 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=64, message="传真长度必须介于 0 和 64 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=64, message="邮箱长度必须介于 0 和 64 之间")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Length(min=0, max=255, message="地图长度必须介于 0 和 255 之间")
	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	
}