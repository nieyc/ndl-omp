/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgood.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.modules.test.entity.TestDataChild;

/**
 * 商品信息Entity
 * @author nieyc
 * @version 2019-08-29
 */
@Table(name="mall_good", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="good_name", attrName="goodName", label="商品简称", queryType=QueryType.LIKE),
		@Column(name="good_full_name", attrName="goodFullName", label="商品全称", queryType=QueryType.LIKE),
		@Column(name="good_type", attrName="goodType", label="产品类型"),
		@Column(name="good_plant_type", attrName="goodPlantType", label="按种植分类"),
		@Column(name="good_price", attrName="goodPrice", label="商品价格", isQuery=false),
		@Column(name="good_price_one", attrName="goodPriceOne", label="会员价格1", isQuery=false),
		@Column(name="good_price_two", attrName="goodPriceTwo", label="会员价格2", isQuery=false),
		@Column(name="is_new", attrName="isNew", label="是否新品"),
		@Column(name="is_hot", attrName="isHot", label="是否热销"),
		@Column(name="good_manufacturers", attrName="goodManufacturers", label="生产厂家", isQuery=false),
		@Column(name="good_brand", attrName="goodBrand", label="商品品牌", isQuery=false),
		@Column(name="good_weight", attrName="goodWeight", label="商品重量", isQuery=false),
		@Column(name="good_inventory", attrName="goodInventory", label="商品库存", isQuery=false),
		@Column(name="good_date", attrName="goodDate", label="上架日期", isQuery=false),
		@Column(name="good_desc", attrName="goodDesc", label="商品信息", isQuery=false),
		@Column(name="sale_flag", attrName="saleFlag", label="是否全部店铺可售商品"),
		@Column(name="create_by", attrName="createBy", label="创建人", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="status", attrName="status", label="状态", comment="状态（0正常 1删除 2停用）", isUpdate=false),
		@Column(name="good_ext1", attrName="goodExt1", label="备用1", isQuery=false),
		@Column(name="good_ext2", attrName="goodExt2", label="备用2", isQuery=false),
		@Column(name="good_ext3", attrName="goodExt3", label="备用3", isQuery=false),
		@Column(name="good_ext4", attrName="goodExt4", label="备用4", isQuery=false),
	}, orderBy="a.id DESC"
)
public class MallGood extends DataEntity<MallGood> {
	
	private static final long serialVersionUID = 1L;
	private String goodName;		// 商品简称
	private String goodFullName;		// 商品全称
	private String goodType;		// 产品类型
	private String goodPlantType;		// 按种植分类
	private Double goodPrice;		// 商品价格
	private String goodPriceOne;		// 会员价格1
	private String goodPriceTwo;		// 会员价格2
	private String isNew;		// 是否新品
	private String isHot;		// 是否热销
	private String goodManufacturers;		// 生产厂家
	private String goodBrand;		// 商品品牌
	private Double goodWeight;		// 商品重量
	private String goodInventory;		// 商品库存
	private Date goodDate;		// 上架日期
	private String goodDesc;		// 商品信息
	private String saleFlag;        //是否全部店铺可售
	private String goodExt1;		// 备用1
	private String goodExt2;		// 备用2
	private String goodExt3;		// 备用3
	private String goodExt4;		// 备用4
	
	
	public MallGood() {
		this(null);
	}

	public MallGood(String id){
		super(id);
	}
	
	@NotBlank(message="商品简称不能为空")
	@Length(min=0, max=255, message="商品简称长度不能超过 255 个字符")
	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	@NotBlank(message="商品全称不能为空")
	@Length(min=0, max=255, message="商品全称长度不能超过 255 个字符")
	public String getGoodFullName() {
		return goodFullName;
	}

	public void setGoodFullName(String goodFullName) {
		this.goodFullName = goodFullName;
	}
	
	@NotBlank(message="产品类型不能为空")
	@Length(min=0, max=255, message="产品类型长度不能超过 255 个字符")
	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	
	@NotBlank(message="按种植分类不能为空")
	@Length(min=0, max=255, message="按种植分类长度不能超过 255 个字符")
	public String getGoodPlantType() {
		return goodPlantType;
	}

	public void setGoodPlantType(String goodPlantType) {
		this.goodPlantType = goodPlantType;
	}
	
	@NotNull(message="商品价格不能为空")
	public Double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}
	
	@Length(min=0, max=255, message="会员价格1长度不能超过 255 个字符")
	public String getGoodPriceOne() {
		return goodPriceOne;
	}

	public void setGoodPriceOne(String goodPriceOne) {
		this.goodPriceOne = goodPriceOne;
	}
	
	@Length(min=0, max=255, message="会员价格2长度不能超过 255 个字符")
	public String getGoodPriceTwo() {
		return goodPriceTwo;
	}

	public void setGoodPriceTwo(String goodPriceTwo) {
		this.goodPriceTwo = goodPriceTwo;
	}
	
	@NotBlank(message="是否新品不能为空")
	@Length(min=0, max=255, message="是否新品长度不能超过 255 个字符")
	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
	@NotBlank(message="是否热销不能为空")
	@Length(min=0, max=255, message="是否热销长度不能超过 255 个字符")
	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	
	@Length(min=0, max=255, message="生产厂家长度不能超过 255 个字符")
	public String getGoodManufacturers() {
		return goodManufacturers;
	}

	public void setGoodManufacturers(String goodManufacturers) {
		this.goodManufacturers = goodManufacturers;
	}
	
	@Length(min=0, max=255, message="商品品牌长度不能超过 255 个字符")
	public String getGoodBrand() {
		return goodBrand;
	}

	public void setGoodBrand(String goodBrand) {
		this.goodBrand = goodBrand;
	}
	
	public Double getGoodWeight() {
		return goodWeight;
	}

	public void setGoodWeight(Double goodWeight) {
		this.goodWeight = goodWeight;
	}
	
	@Length(min=0, max=255, message="商品库存长度不能超过 255 个字符")
	public String getGoodInventory() {
		return goodInventory;
	}

	public void setGoodInventory(String goodInventory) {
		this.goodInventory = goodInventory;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGoodDate() {
		return goodDate;
	}

	public void setGoodDate(Date goodDate) {
		this.goodDate = goodDate;
	}
	
	@Length(min=0, max=2000, message="商品信息长度不能超过 2000 个字符")
	public String getGoodDesc() {
		return goodDesc;
	}

	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	
	@Length(min=0, max=255, message="备用1长度不能超过 255 个字符")
	public String getGoodExt1() {
		return goodExt1;
	}

	public void setGoodExt1(String goodExt1) {
		this.goodExt1 = goodExt1;
	}
	
	@Length(min=0, max=255, message="备用2长度不能超过 255 个字符")
	public String getGoodExt2() {
		return goodExt2;
	}

	public void setGoodExt2(String goodExt2) {
		this.goodExt2 = goodExt2;
	}
	
	@Length(min=0, max=255, message="备用3长度不能超过 255 个字符")
	public String getGoodExt3() {
		return goodExt3;
	}

	public void setGoodExt3(String goodExt3) {
		this.goodExt3 = goodExt3;
	}
	
	@Length(min=0, max=255, message="备用4长度不能超过 255 个字符")
	public String getGoodExt4() {
		return goodExt4;
	}

	public void setGoodExt4(String goodExt4) {
		this.goodExt4 = goodExt4;
	}

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag;
    }

	
	
}