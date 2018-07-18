/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.BusinessModel;
import com.thinkgem.jeesite.modules.cms.dao.BusinessModelDao;

/**
 * 经营模式Service
 * @author xionghl
 * @version 2018-07-16
 */
@Service
@Transactional(readOnly = true)
public class BusinessModelService extends CrudService<BusinessModelDao, BusinessModel> {

	public BusinessModel get(String id) {
		return super.get(id);
	}
	
	public List<BusinessModel> findList(BusinessModel businessModel) {
		return super.findList(businessModel);
	}
	
	public Page<BusinessModel> findPage(Page<BusinessModel> page, BusinessModel businessModel) {
		page.setOrderBy("sort desc");
		return super.findPage(page, businessModel);
	}
	
	@Transactional(readOnly = false)
	public void save(BusinessModel businessModel) {
		super.save(businessModel);
	}
	
	@Transactional(readOnly = false)
	public void delete(BusinessModel businessModel) {
		super.delete(businessModel);
	}
	
}