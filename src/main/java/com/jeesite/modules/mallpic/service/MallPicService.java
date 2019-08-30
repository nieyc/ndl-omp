/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallpic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.mallpic.entity.MallPic;
import com.jeesite.modules.mallpic.dao.MallPicDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 测试图片Service
 * @author nieyc
 * @version 2019-08-29
 */
@Service
@Transactional(readOnly=true)
public class MallPicService extends CrudService<MallPicDao, MallPic> {
	
	/**
	 * 获取单条数据
	 * @param mallPic
	 * @return
	 */
	@Override
	public MallPic get(MallPic mallPic) {
		return super.get(mallPic);
	}
	
	/**
	 * 查询分页数据
	 * @param mallPic 查询条件
	 * @param mallPic.page 分页对象
	 * @return
	 */
	@Override
	public Page<MallPic> findPage(MallPic mallPic) {
		return super.findPage(mallPic);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mallPic
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MallPic mallPic) {
		super.save(mallPic);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(mallPic.getId(), "mallPic_image");
	}
	
	/**
	 * 更新状态
	 * @param mallPic
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MallPic mallPic) {
		super.updateStatus(mallPic);
	}
	
	/**
	 * 删除数据
	 * @param mallPic
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MallPic mallPic) {
		super.delete(mallPic);
	}
	
}