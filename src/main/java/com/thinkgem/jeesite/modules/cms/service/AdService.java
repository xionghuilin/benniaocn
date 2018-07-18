/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.Ad;
import com.thinkgem.jeesite.modules.cms.dao.AdDao;

/**
 * 广告设置Service
 * @author xionghl
 * @version 2018-07-03
 */
@Service
@Transactional(readOnly = true)
public class AdService extends CrudService<AdDao, Ad> {

	public Ad get(String id) {
		return super.get(id);
	}
	
	public List<Ad> findList(Ad ad) {
		return super.findList(ad);
	}
	
	public Page<Ad> findPage(Page<Ad> page, Ad ad) {
		return super.findPage(page, ad);
	}
	
	@Transactional(readOnly = false)
	public void save(Ad ad) {
		super.save(ad);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ad ad) {
		super.delete(ad);
	}
	
}