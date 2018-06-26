/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.BusinessMovement;
import com.thinkgem.jeesite.modules.cms.dao.BusinessMovementDao;

/**
 * 企业动态Service
 * @author xionghl
 * @version 2018-06-25
 */
@Service
@Transactional(readOnly = true)
public class BusinessMovementService extends CrudService<BusinessMovementDao, BusinessMovement> {

	public BusinessMovement get(String id) {
		return super.get(id);
	}
	
	public List<BusinessMovement> findList(BusinessMovement businessMovement) {
		return super.findList(businessMovement);
	}
	
	public Page<BusinessMovement> findPage(Page<BusinessMovement> page, BusinessMovement businessMovement) {
		return super.findPage(page, businessMovement);
	}
	
	@Transactional(readOnly = false)
	public void save(BusinessMovement businessMovement) {
		super.save(businessMovement);
	}
	
	@Transactional(readOnly = false)
	public void delete(BusinessMovement businessMovement) {
		super.delete(businessMovement);
	}
	
}