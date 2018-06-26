/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.Partner;
import com.thinkgem.jeesite.modules.cms.dao.PartnerDao;

/**
 * 合作伙伴Service
 * @author xionghl
 * @version 2018-06-25
 */
@Service
@Transactional(readOnly = true)
public class PartnerService extends CrudService<PartnerDao, Partner> {

	public Partner get(String id) {
		return super.get(id);
	}
	
	public List<Partner> findList(Partner partner) {
		return super.findList(partner);
	}
	
	public Page<Partner> findPage(Page<Partner> page, Partner partner) {
		return super.findPage(page, partner);
	}
	
	@Transactional(readOnly = false)
	public void save(Partner partner) {
		super.save(partner);
	}
	
	@Transactional(readOnly = false)
	public void delete(Partner partner) {
		super.delete(partner);
	}
	
}