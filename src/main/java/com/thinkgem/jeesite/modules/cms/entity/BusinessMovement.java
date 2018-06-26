/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 企业动态Entity
 * @author xionghl
 * @version 2018-06-25
 */
public class BusinessMovement extends DataEntity<BusinessMovement> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private Integer status;		// 状态
	
	public BusinessMovement() {
		super();
	}

	public BusinessMovement(String id){
		super(id);
	}

	@Length(min=1, max=255, message="标题长度必须介于 1 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotNull(message="状态不能为空")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}