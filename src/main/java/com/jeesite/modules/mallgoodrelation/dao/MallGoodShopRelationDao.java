/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodrelation.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.mallgoodrelation.entity.MallGoodShopRelation;

/**
 * 商品店铺关系DAO接口
 * @author nieyc
 * @version 2019-08-30
 */
@MyBatisDao
public interface MallGoodShopRelationDao extends CrudDao<MallGoodShopRelation> {
   
    public void deleteByGoodId(String goodId);
}