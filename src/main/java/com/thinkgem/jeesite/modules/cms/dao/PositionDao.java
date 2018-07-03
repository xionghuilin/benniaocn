/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.Position;

/**
 * 招聘信息DAO接口
 * @author xionghl
 * @version 2018-06-29
 */
@MyBatisDao
public interface PositionDao extends CrudDao<Position> {
	
}