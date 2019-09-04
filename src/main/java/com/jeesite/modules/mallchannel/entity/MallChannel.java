/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallchannel.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 产品分类Entity
 * @author nieyc
 * @version 2019-09-04
 */
@Table(name="mall_channel", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="分类名称", queryType=QueryType.LIKE),
		@Column(name="url", attrName="url", label="链接地址"),
		@Column(name="icon_url", attrName="iconUrl", label="图标地址"),
		@Column(name="sort_order", attrName="sortOrder", label="排序"),
	}, orderBy="a.sort_order"
)
public class MallChannel extends DataEntity<MallChannel> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 分类名称
	private String url;		// 链接地址
	private String iconUrl;		// 图标地址
	private Integer sortOrder;		// 排序
	
	public MallChannel() {
		this(null);
	}

	public MallChannel(String id){
		super(id);
	}
	
	@NotBlank(message="分类名称不能为空")
	@Length(min=0, max=45, message="分类名称长度不能超过 45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="链接地址不能为空")
	@Length(min=0, max=255, message="链接地址长度不能超过 255 个字符")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@NotBlank(message="图标地址不能为空")
	@Length(min=0, max=255, message="图标地址长度不能超过 255 个字符")
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	@NotNull(message="排序不能为空")
	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}