/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 服务流程Entity
 * @author xionghl
 * @version 2018-07-12
 */
public class Process extends DataEntity<Process> {
	
	private static final long serialVersionUID = 1L;
	private String content;		// 内容
	private String sort;		// 排序
	
	public Process() {
		super();
	}

	public Process(String id){
		super(id);
	}

	@Length(min=0, max=255, message="内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}