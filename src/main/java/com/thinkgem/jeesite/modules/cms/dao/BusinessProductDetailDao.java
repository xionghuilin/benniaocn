/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.BusinessProductDetail;

/**
 * 经营产品DAO接口
 * @author xionghl
 * @version 2018-07-18
 */
@MyBatisDao
public interface BusinessProductDetailDao extends CrudDao<BusinessProductDetail> {
	
}