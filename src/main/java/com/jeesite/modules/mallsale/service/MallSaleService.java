/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallsale.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallsale.entity.MallSale;
import com.jeesite.modules.mallsale.dao.MallSaleDao;

/**
 * mall_saleService
 * @author nieyc
 * @version 2019-08-29
 */
@Service
@Transactional(readOnly=true)
public class MallSaleService extends CrudService<MallSaleDao, MallSale> {
	
	/**
	 * 获取单条数据
	 * @param mallSale
	 * @return
	 */
	@Override
	public MallSale get(MallSale mallSale) {
		return super.get(mallSale);
	}
	
	/**
	 * 查询分页数据
	 * @param mallSale 查询条件
	 * @param mallSale.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallSale> findPage(MallSale mallSale) {
		return super.findPage(mallSale);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallSale
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallSale mallSale) {
		super.save(mallSale);
	}
	
	/**
	 * 更新状态
	 * @param mallSale
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallSale mallSale) {
		super.updateStatus(mallSale);
	}
	
	/**
	 * 删除数据
	 * @param mallSale
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallSale mallSale) {
		super.delete(mallSale);
	}
	
}