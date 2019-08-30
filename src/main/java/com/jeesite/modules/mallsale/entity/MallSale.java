/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallsale.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * mall_saleEntity
 * @author nieyc
 * @version 2019-08-29
 */
@Table(name="mall_sale", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="mobile", attrName="mobile", label="手机号码"),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="open_id", attrName="openId", label="open_id", isUpdate=false, isQuery=false),
		@Column(name="status", attrName="status", label="删除状态", isUpdate=false),
	}, orderBy="a.id DESC"
)
public class MallSale extends DataEntity<MallSale> {
	
	private static final long serialVersionUID = 1L;
	private String mobile;		// 手机号码
	private String name;		// 姓名
	private String openId;		// open_id
	
	public MallSale() {
		this(null);
	}

	public MallSale(String id){
		super(id);
	}
	
	@NotBlank(message="手机号码不能为空")
	@Length(min=0, max=11, message="手机号码长度不能超过 11 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="姓名不能为空")
	@Length(min=0, max=255, message="姓名长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}