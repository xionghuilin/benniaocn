/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.Partner;

/**
 * 合作伙伴DAO接口
 * @author xionghl
 * @version 2018-06-25
 */
@MyBatisDao
public interface PartnerDao extends CrudDao<Partner> {
	
}