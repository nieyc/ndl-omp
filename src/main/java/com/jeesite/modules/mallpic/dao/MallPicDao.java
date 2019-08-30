/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallpic.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallpic.entity.MallPic;

/**
 * 测试图片DAO接口
 * @author nieyc
 * @version 2019-08-29
 */
@MyBatisDao
public interface MallPicDao extends CrudDao<MallPic> {
	
}