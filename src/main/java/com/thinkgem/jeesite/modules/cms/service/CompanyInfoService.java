/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CompanyInfo;
import com.thinkgem.jeesite.modules.cms.dao.CompanyInfoDao;

/**
 * 公司信息Service
 * @author xionghl
 * @version 2018-06-23
 */
@Service
@Transactional(readOnly = true)
public class CompanyInfoService extends CrudService<CompanyInfoDao, CompanyInfo> {

	public CompanyInfo get(String id) {
		return super.get(id);
	}
	
	public List<CompanyInfo> findList(CompanyInfo companyInfo) {
		return super.findList(companyInfo);
	}
	
	public Page<CompanyInfo> findPage(Page<CompanyInfo> page, CompanyInfo companyInfo) {
		return super.findPage(page, companyInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(CompanyInfo companyInfo) {
		super.save(companyInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(CompanyInfo companyInfo) {
		super.delete(companyInfo);
	}
	
}