/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.BusinessModel;

/**
 * 经营模式DAO接口
 * @author xionghl
 * @version 2018-07-16
 */
@MyBatisDao
public interface BusinessModelDao extends CrudDao<BusinessModel> {
	
}