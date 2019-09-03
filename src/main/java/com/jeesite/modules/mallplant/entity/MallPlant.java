/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallplant.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 植物分类Entity
 * @author nieyc
 * @version 2019-08-31
 */
@Table(name="mall_plant", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="分类名称", queryType=QueryType.LIKE),
		@Column(name="url", attrName="url", label="url", isQuery=false),
		@Column(name="icon_url", attrName="iconUrl", label="图片地址", isQuery=false),
		@Column(name="sort_order", attrName="sortOrder", label="排序", isQuery=false),
	}, orderBy="a.sort_order"
)
public class MallPlant extends DataEntity<MallPlant> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 分类名称
	private String url;		// url
	private String iconUrl;		// 图片地址
	private Integer sortOrder;		// 排序
	
	public MallPlant() {
		this(null);
	}

	public MallPlant(String id){
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
	
	@NotBlank(message="url不能为空")
	@Length(min=0, max=255, message="url长度不能超过 255 个字符")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@NotBlank(message="图片地址不能为空")
	@Length(min=0, max=255, message="图片地址长度不能超过 255 个字符")
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