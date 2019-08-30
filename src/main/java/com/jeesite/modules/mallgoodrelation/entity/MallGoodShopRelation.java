/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodrelation.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 商品店铺关系Entity
 * @author nieyc
 * @version 2019-08-30
 */
@Table(name="mall_good_shop_relation", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="shop_code", attrName="shopCode", label="商铺编号"),
		@Column(name="good_id", attrName="goodId", label="商品id"),
	}, orderBy="a.id DESC"
)
public class MallGoodShopRelation extends DataEntity<MallGoodShopRelation> {
	
	private static final long serialVersionUID = 1L;
	private String shopCode;		// 商铺编号
	private String goodId;		// 商品id
	
	public MallGoodShopRelation() {
		this(null);
	}

	public MallGoodShopRelation(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="商铺编号长度不能超过 255 个字符")
	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	
	@Length(min=0, max=50, message="商品id长度不能超过 50 个字符")
	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
}