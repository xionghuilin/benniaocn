/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.Process;
import com.thinkgem.jeesite.modules.cms.dao.ProcessDao;

/**
 * 服务流程Service
 * @author xionghl
 * @version 2018-07-12
 */
@Service
@Transactional(readOnly = true)
public class ProcessService extends CrudService<ProcessDao, Process> {

	public Process get(String id) {
		return super.get(id);
	}
	
	public List<Process> findList(Process process) {
		return super.findList(process);
	}
	
	public Page<Process> findPage(Page<Process> page, Process process) {
		page.setOrderBy("sort desc");
		return super.findPage(page, process);
	}
	
	@Transactional(readOnly = false)
	public void save(Process process) {
		super.save(process);
	}
	
	@Transactional(readOnly = false)
	public void delete(Process process) {
		super.delete(process);
	}
	
}