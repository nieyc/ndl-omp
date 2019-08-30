/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgood.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallgood.entity.MallGood;

/**
 * 商品信息DAO接口
 * @author nieyc
 * @version 2019-08-29
 */
@MyBatisDao
public interface MallGoodDao extends CrudDao<MallGood> {
	
}