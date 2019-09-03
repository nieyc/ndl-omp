/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallplant.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallplant.entity.MallPlant;

/**
 * 植物分类DAO接口
 * @author nieyc
 * @version 2019-08-31
 */
@MyBatisDao
public interface MallPlantDao extends CrudDao<MallPlant> {
	
}