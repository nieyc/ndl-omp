/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallpic.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 测试图片Entity
 * @author nieyc
 * @version 2019-08-29
 */
@Table(name="mall_pic", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="pic_url", attrName="picUrl", label="图片"),
		@Column(name="bz", attrName="bz", label="详情"),
	}, orderBy="a.id DESC"
)
public class MallPic extends DataEntity<MallPic> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String picUrl;		// 图片
	private String bz;
	
	public MallPic() {
		this(null);
	}

	public MallPic(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=2000, message="图片长度不能超过 2000 个字符")
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }


	
	
	
}