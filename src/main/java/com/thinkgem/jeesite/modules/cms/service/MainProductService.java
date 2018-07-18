/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.MainProduct;
import com.thinkgem.jeesite.modules.cms.dao.MainProductDao;

/**
 * 主打产品Service
 * @author xionghl
 * @version 2018-07-03
 */
@Service
@Transactional(readOnly = true)
public class MainProductService extends CrudService<MainProductDao, MainProduct> {

	public MainProduct get(String id) {
		return super.get(id);
	}
	
	public List<MainProduct> findList(MainProduct mainProduct) {
		return super.findList(mainProduct);
	}
	
	public Page<MainProduct> findPage(Page<MainProduct> page, MainProduct mainProduct) {
		return super.findPage(page, mainProduct);
	}
	
	@Transactional(readOnly = false)
	public void save(MainProduct mainProduct) {
		super.save(mainProduct);
	}
	
	@Transactional(readOnly = false)
	public void delete(MainProduct mainProduct) {
		super.delete(mainProduct);
	}
	
}