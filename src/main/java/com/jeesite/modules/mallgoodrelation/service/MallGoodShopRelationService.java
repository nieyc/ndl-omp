/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodrelation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallgoodrelation.entity.MallGoodShopRelation;
import com.jeesite.modules.mallgoodrelation.dao.MallGoodShopRelationDao;

/**
 * 商品店铺关系Service
 * @author nieyc
 * @version 2019-08-30
 */
@Service
@Transactional(readOnly=true)
public class MallGoodShopRelationService extends CrudService<MallGoodShopRelationDao, MallGoodShopRelation> {
    
    @Resource
    MallGoodShopRelationDao mallGoodShopRelationDao;
	
	/**
	 * 获取单条数据
	 * @param mallGoodShopRelation
	 * @return
	 */
	@Override
	public MallGoodShopRelation get(MallGoodShopRelation mallGoodShopRelation) {
		return super.get(mallGoodShopRelation);
	}
	
	/**
	 * 查询分页数据
	 * @param mallGoodShopRelation 查询条件
	 * @param mallGoodShopRelation.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallGoodShopRelation> findPage(MallGoodShopRelation mallGoodShopRelation) {
		return super.findPage(mallGoodShopRelation);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallGoodShopRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallGoodShopRelation mallGoodShopRelation) {
		super.save(mallGoodShopRelation);
	}
	
	/**
	 * 更新状态
	 * @param mallGoodShopRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallGoodShopRelation mallGoodShopRelation) {
		super.updateStatus(mallGoodShopRelation);
	}
	
	/**
	 * 删除数据
	 * @param mallGoodShopRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallGoodShopRelation mallGoodShopRelation) {
		super.delete(mallGoodShopRelation);
	}
	
	public void deleteByGoodId(String goodId) {
	    mallGoodShopRelationDao.deleteByGoodId(goodId);
    }
	
}