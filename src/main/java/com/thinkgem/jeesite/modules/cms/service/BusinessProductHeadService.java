/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.BusinessProductHead;
import com.thinkgem.jeesite.modules.cms.dao.BusinessProductHeadDao;
import com.thinkgem.jeesite.modules.cms.entity.BusinessProductDetail;
import com.thinkgem.jeesite.modules.cms.dao.BusinessProductDetailDao;

/**
 * 经营产品Service
 * @author xionghl
 * @version 2018-07-18
 */
@Service
@Transactional(readOnly = true)
public class BusinessProductHeadService extends CrudService<BusinessProductHeadDao, BusinessProductHead> {

	@Autowired
	private BusinessProductDetailDao businessProductDetailDao;
	
	public BusinessProductHead get(String id) {
		BusinessProductHead businessProductHead = super.get(id);
		businessProductHead.setBusinessProductDetailList(businessProductDetailDao.findList(new BusinessProductDetail(businessProductHead)));
		return businessProductHead;
	}
	
	public List<BusinessProductHead> findList(BusinessProductHead businessProductHead) {
		return super.findList(businessProductHead);
	}
	
	public Page<BusinessProductHead> findPage(Page<BusinessProductHead> page, BusinessProductHead businessProductHead) {
		return super.findPage(page, businessProductHead);
	}
	
	@Transactional(readOnly = false)
	public void save(BusinessProductHead businessProductHead) {
		super.save(businessProductHead);
		for (BusinessProductDetail businessProductDetail : businessProductHead.getBusinessProductDetailList()){
			if (businessProductDetail.getId() == null){
				continue;
			}
			if (BusinessProductDetail.DEL_FLAG_NORMAL.equals(businessProductDetail.getDelFlag())){
				if (StringUtils.isBlank(businessProductDetail.getId())){
					businessProductDetail.setProduct(businessProductHead);
					businessProductDetail.preInsert();
					businessProductDetailDao.insert(businessProductDetail);
				}else{
					businessProductDetail.preUpdate();
					businessProductDetailDao.update(businessProductDetail);
				}
			}else{
				businessProductDetailDao.delete(businessProductDetail);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(BusinessProductHead businessProductHead) {
		super.delete(businessProductHead);
		businessProductDetailDao.delete(new BusinessProductDetail(businessProductHead));
	}
	
}