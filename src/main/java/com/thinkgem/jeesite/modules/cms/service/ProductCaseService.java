/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.ProductCase;
import com.thinkgem.jeesite.modules.cms.dao.ProductCaseDao;

/**
 * 产品案例Service
 * @author xionghl
 * @version 2018-07-03
 */
@Service
@Transactional(readOnly = true)
public class ProductCaseService extends CrudService<ProductCaseDao, ProductCase> {

	public ProductCase get(String id) {
		return super.get(id);
	}
	
	public List<ProductCase> findList(ProductCase productCase) {
		return super.findList(productCase);
	}
	
	public Page<ProductCase> findPage(Page<ProductCase> page, ProductCase productCase) {
		return super.findPage(page, productCase);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductCase productCase) {
		super.save(productCase);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductCase productCase) {
		super.delete(productCase);
	}
	
}