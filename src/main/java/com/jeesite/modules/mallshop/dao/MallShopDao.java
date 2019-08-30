/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallshop.dao;

import java.util.List;
import java.util.Map;

import com.jeesite.common.dao.TreeDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallshop.entity.MallShop;

/**
 * 门店信息DAO接口
 * @author nieyc
 * @version 2019-08-27
 */
@MyBatisDao
public interface MallShopDao extends TreeDao<MallShop> {
    
    public List<MallShop> getMallShopList(MallShop mallShop);
    
    public List<MallShop> getLastLevelShop();
        
	
}