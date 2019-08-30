/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallshop.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.entity.TreeEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 门店信息Entity
 * @author nieyc
 * @version 2019-08-27
 */
@Table(name="mall_shop", alias="a", columns={
		@Column(name="tree_code", attrName="treeCode", label="节点编码", isPK=true),
		@Column(includeEntity=TreeEntity.class),
		@Column(name="tree_name", attrName="treeName", label="门店名称", queryType=QueryType.LIKE, isTreeName=true),
		@Column(name="lat_num", attrName="latNum", label="经度", isQuery=false),
		@Column(name="lon_num", attrName="lonNum", label="纬度", isQuery=false),
		@Column(name="address", attrName="address", label="地址", isQuery=false),
		@Column(name="pass_word", attrName="passWord", label="登录密码", isQuery=false),
		@Column(name="phone", attrName="phone", label="联系电话"),
		@Column(name="sale_man_id", attrName="saleManId", label="业务员"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_name", attrName="userName", label="门店经理", queryType=QueryType.LIKE),
	}, orderBy="a.tree_sorts, a.tree_code"
)
public class MallShop extends TreeEntity<MallShop> {
	
	private static final long serialVersionUID = 1L;
	private String treeCode;		// 节点编码
	private String treeName;		// 门店名称
	private BigDecimal latNum;		// 经度
	private BigDecimal lonNum;		// 纬度
	private String address;		// 地址
	private String passWord;		// 登录密码
	private String phone;		// 联系电话
	private String userName;		// 门店经理
	private String saleManId;         //业务员
	private String saleManName; 
	
	
	public MallShop() {
		this(null);
	}

	public MallShop(String id){
		super(id);
	}
	
	@Override
	public MallShop getParent() {
		return parent;
	}

	@Override
	public void setParent(MallShop parent) {
		this.parent = parent;
	}
	
	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	
	@NotBlank(message="门店名称不能为空")
	@Length(min=0, max=200, message="门店名称长度不能超过 200 个字符")
	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	
	public BigDecimal getLatNum() {
		return latNum;
	}

	public void setLatNum(BigDecimal latNum) {
		this.latNum = latNum;
	}
	
	public BigDecimal getLonNum() {
		return lonNum;
	}

	public void setLonNum(BigDecimal lonNum) {
		this.lonNum = lonNum;
	}
	
	@Length(min=0, max=255, message="地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@NotBlank(message="登录密码不能为空")
	@Length(min=0, max=255, message="登录密码长度不能超过 255 个字符")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@NotBlank(message="手机号码不能为空")
	@Length(min=0, max=11, message="手机号码长度不能超过11 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=255, message="门店经理长度不能超过 255 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    public String getSaleManId() {
        return saleManId;
    }

    public void setSaleManId(String saleManId) {
        this.saleManId = saleManId;
    }

    public String getSaleManName() {
        return saleManName;
    }

    public void setSaleManName(String saleManName) {
        this.saleManName = saleManName;
    }
	
    
	
	
	
}