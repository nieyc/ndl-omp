/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodattr.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * mall_good_attributeEntity
 * @author nieyc
 * @version 2019-09-03
 */
@Table(name="mall_good_attribute", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="good_id", attrName="goodId", label="商品id"),
		@Column(name="attribute_id", attrName="attributeId", label="字典属性"),
		@Column(name="value", attrName="value", label="商品属性"),
		@Column(name="status", attrName="status", label="status", isUpdate=false),
	}, orderBy="a.id DESC"
)
public class MallGoodAttribute extends DataEntity<MallGoodAttribute> {
	
	private static final long serialVersionUID = 1L;
	private String goodId;		// 商品id
	private String attributeId;		// 字典属性
	private String value;		// 商品属性
	
	public MallGoodAttribute() {
		this(null);
	}

	public MallGoodAttribute(String id){
		super(id);
	}
	
	@NotBlank(message="商品id不能为空")
	@Length(min=0, max=50, message="商品id长度不能超过 50 个字符")
	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
	@NotBlank(message="字典属性不能为空")
	@Length(min=0, max=50, message="字典属性长度不能超过 50 个字符")
	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}
	
	@NotBlank(message="商品属性不能为空")
	@Length(min=0, max=50, message="商品属性长度不能超过 50 个字符")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}