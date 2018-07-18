/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 经营产品Entity
 * @author xionghl
 * @version 2018-07-18
 */
public class BusinessProductDetail extends DataEntity<BusinessProductDetail> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String content;		// 内容
	private String status;		// 状态
	private BusinessProductHead productId;		// 经营产品主表id 父类
	
	public BusinessProductDetail() {
		super();
	}

	public BusinessProductDetail(String id){
		super(id);
	}

	public BusinessProductDetail(BusinessProductHead productId){
		this.productId = productId;
	}

	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=1, message="状态长度必须介于 1 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=1, max=64, message="经营产品主表id长度必须介于 1 和 64 之间")
	public BusinessProductHead getProductId() {
		return productId;
	}

	public void setProductId(BusinessProductHead productId) {
		this.productId = productId;
	}
	
}