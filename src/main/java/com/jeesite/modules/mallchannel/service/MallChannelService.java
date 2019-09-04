/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallchannel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallchannel.entity.MallChannel;
import com.jeesite.modules.mallchannel.dao.MallChannelDao;

/**
 * 产品分类Service
 * @author nieyc
 * @version 2019-09-04
 */
@Service
@Transactional(readOnly=true)
public class MallChannelService extends CrudService<MallChannelDao, MallChannel> {
	
	/**
	 * 获取单条数据
	 * @param mallChannel
	 * @return
	 */
	@Override
	public MallChannel get(MallChannel mallChannel) {
		return super.get(mallChannel);
	}
	
	/**
	 * 查询分页数据
	 * @param mallChannel 查询条件
	 * @param mallChannel.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallChannel> findPage(MallChannel mallChannel) {
		return super.findPage(mallChannel);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallChannel
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallChannel mallChannel) {
		super.save(mallChannel);
	}
	
	/**
	 * 更新状态
	 * @param mallChannel
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallChannel mallChannel) {
		super.updateStatus(mallChannel);
	}
	
	/**
	 * 删除数据
	 * @param mallChannel
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallChannel mallChannel) {
		super.delete(mallChannel);
	}
	
}