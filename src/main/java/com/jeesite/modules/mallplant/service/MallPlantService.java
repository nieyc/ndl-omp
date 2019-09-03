/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallplant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallplant.entity.MallPlant;
import com.jeesite.modules.mallplant.dao.MallPlantDao;

/**
 * 植物分类Service
 * @author nieyc
 * @version 2019-08-31
 */
@Service
@Transactional(readOnly=true)
public class MallPlantService extends CrudService<MallPlantDao, MallPlant> {
	
	/**
	 * 获取单条数据
	 * @param mallPlant
	 * @return
	 */
	@Override
	public MallPlant get(MallPlant mallPlant) {
		return super.get(mallPlant);
	}
	
	/**
	 * 查询分页数据
	 * @param mallPlant 查询条件
	 * @param mallPlant.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallPlant> findPage(MallPlant mallPlant) {
		return super.findPage(mallPlant);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallPlant
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallPlant mallPlant) {
		super.save(mallPlant);
	}
	
	/**
	 * 更新状态
	 * @param mallPlant
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallPlant mallPlant) {
		super.updateStatus(mallPlant);
	}
	
	/**
	 * 删除数据
	 * @param mallPlant
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallPlant mallPlant) {
		super.delete(mallPlant);
	}
	
}