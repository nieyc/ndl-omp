/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallgood.entity.MallGood;
import com.jeesite.modules.mallgoodrelation.entity.MallGoodShopRelation;
import com.jeesite.modules.mallgoodrelation.service.MallGoodShopRelationService;
import com.jeesite.modules.mallgood.dao.MallGoodDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 商品信息Service
 * @author nieyc
 * @version 2019-08-29
 */
@Service
@Transactional(readOnly=true)
public class MallGoodService extends CrudService<MallGoodDao, MallGood> {
    
    @Autowired
    private MallGoodShopRelationService mallGoodShopRelationService;
	
	/**
	 * 获取单条数据
	 * @param mallGood
	 * @return
	 */
	@Override
	public MallGood get(MallGood mallGood) {
		return super.get(mallGood);
	}
	
	/**
	 * 查询分页数据
	 * @param mallGood 查询条件
	 * @param mallGood.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallGood> findPage(MallGood mallGood) {
		return super.findPage(mallGood);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallGood mallGood) {
	    String[] shops=null;
	    if(!mallGood.getSaleFlag().equals("0")) {
            shops=mallGood.getSaleFlag().split(",");
	        mallGood.setSaleFlag("1");
	    }else {
	        mallGoodShopRelationService.deleteByGoodId(mallGood.getId());
	    }
		super.save(mallGood);
	    if(mallGood.getSaleFlag().equals("1")) {
             mallGoodShopRelationService.deleteByGoodId(mallGood.getId());
             for(int i=0;i<shops.length;i++) {
                MallGoodShopRelation mallGoodShopRelation=new MallGoodShopRelation();
                mallGoodShopRelation.setGoodId(mallGood.getId());
                mallGoodShopRelation.setShopCode(shops[i]);
                mallGoodShopRelationService.save(mallGoodShopRelation);
             }
	   }
		// 保存上传图片
		FileUploadUtils.saveFileUpload(mallGood.getId(), "mallGood_image");
	}
	
	/**
	 * 更新状态
	 * @param mallGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallGood mallGood) {
		super.updateStatus(mallGood);
	}
	
	/**
	 * 删除数据
	 * @param mallGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallGood mallGood) {
	    mallGoodShopRelationService.deleteByGoodId(mallGood.getId());
		super.delete(mallGood);
	}
	
}