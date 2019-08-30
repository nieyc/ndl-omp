/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallsale.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallsale.entity.MallSale;

/**
 * mall_saleDAO接口
 * @author nieyc
 * @version 2019-08-29
 */
@MyBatisDao
public interface MallSaleDao extends CrudDao<MallSale> {
	
}