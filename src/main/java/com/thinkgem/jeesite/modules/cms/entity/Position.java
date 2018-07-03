/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 招聘信息Entity
 * @author xionghl
 * @version 2018-06-29
 */
public class Position extends DataEntity<Position> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 职位名称
	private String description;		// 职位描述
	private String requirements;		// 职位要求
	private String contact;		// 联系方式
	private String status;		// 在线状态
	
	public Position() {
		super();
	}

	public Position(String id){
		super(id);
	}

	@Length(min=1, max=255, message="职位名称长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	@Length(min=0, max=255, message="联系方式长度必须介于 0 和 255 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Length(min=0, max=1, message="在线状态长度必须介于 0 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}