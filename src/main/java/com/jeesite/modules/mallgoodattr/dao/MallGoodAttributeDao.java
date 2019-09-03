/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodattr.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallgoodattr.entity.MallGoodAttribute;

/**
 * mall_good_attributeDAO接口
 * @author nieyc
 * @version 2019-09-03
 */
@MyBatisDao
public interface MallGoodAttributeDao extends CrudDao<MallGoodAttribute> {
	
}