/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.ProductCase;

/**
 * 产品案例DAO接口
 * @author xionghl
 * @version 2018-07-03
 */
@MyBatisDao
public interface ProductCaseDao extends CrudDao<ProductCase> {
	
}