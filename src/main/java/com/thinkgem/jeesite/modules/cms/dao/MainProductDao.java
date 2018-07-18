/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.MainProduct;

/**
 * 主打产品DAO接口
 * @author xionghl
 * @version 2018-07-03
 */
@MyBatisDao
public interface MainProductDao extends CrudDao<MainProduct> {
	
}