/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallshop.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.TreeService;
import com.jeesite.modules.mallshop.entity.MallShop;
import com.jeesite.modules.mallshop.dao.MallShopDao;

/**
 * 门店信息Service
 * @author nieyc
 * @version 2019-08-27
 */
@Service
@Transactional(readOnly=true)
public class MallShopService extends TreeService<MallShopDao, MallShop> {
    
    @Resource
    MallShopDao mallShopDao;
	
	/**
	 * 获取单条数据
	 * @param mallShop
	 * @return
	 */
	@Override
	public MallShop get(MallShop mallShop) {
		return super.get(mallShop);
	}
	
	/**
	 * 查询列表数据
	 * @param mallShop
	 * @return
	 */
	@Override
	public List<MallShop> findList(MallShop mallShop) {
		return super.findList(mallShop);
	}
	
    public List<MallShop> getMallShopList(MallShop mallShop) {
        return mallShopDao.getMallShopList(mallShop);
    }
    
    
    public List<MallShop> getLastLevelShop(){
        return mallShopDao.getLastLevelShop();
    }
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallShop
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallShop mallShop) {
		super.save(mallShop);
	}
	
	/**
	 * 更新状态
	 * @param mallShop
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallShop mallShop) {
		super.updateStatus(mallShop);
	}
	
	/**
	 * 删除数据
	 * @param mallShop
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallShop mallShop) {
		super.delete(mallShop);
	}
	
}