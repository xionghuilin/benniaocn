/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.ServiceAdvantage;
import com.thinkgem.jeesite.modules.cms.dao.ServiceAdvantageDao;

/**
 * 服务优势Service
 * @author xionghl
 * @version 2018-06-25
 */
@Service
@Transactional(readOnly = true)
public class ServiceAdvantageService extends CrudService<ServiceAdvantageDao, ServiceAdvantage> {

	public ServiceAdvantage get(String id) {
		return super.get(id);
	}
	
	public List<ServiceAdvantage> findList(ServiceAdvantage serviceAdvantage) {
		return super.findList(serviceAdvantage);
	}
	
	public Page<ServiceAdvantage> findPage(Page<ServiceAdvantage> page, ServiceAdvantage serviceAdvantage) {
		return super.findPage(page, serviceAdvantage);
	}
	
	@Transactional(readOnly = false)
	public void save(ServiceAdvantage serviceAdvantage) {
		super.save(serviceAdvantage);
	}
	
	@Transactional(readOnly = false)
	public void delete(ServiceAdvantage serviceAdvantage) {
		super.delete(serviceAdvantage);
	}
	
}