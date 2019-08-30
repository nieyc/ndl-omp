/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallpic.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.mallpic.entity.MallPic;
import com.jeesite.modules.mallpic.service.MallPicService;
import com.jeesite.modules.mallsale.entity.MallSale;
import com.jeesite.modules.mallsale.service.MallSaleService;

/**
 * 测试图片Controller
 * @author nieyc
 * @version 2019-08-29
 */
@Controller
@RequestMapping(value = "${adminPath}/mallpic/mallPic")
public class MallPicController extends BaseController {

	@Autowired
	private MallPicService mallPicService;
	
	   @Autowired
	    private MallSaleService mallSaleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallPic get(String id, boolean isNewRecord) {
		return mallPicService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallpic:mallPic:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallPic mallPic, Model model) {
		model.addAttribute("mallPic", mallPic);
		return "modules/mallpic/mallPicList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallpic:mallPic:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallPic> listData(MallPic mallPic, HttpServletRequest request, HttpServletResponse response) {
		mallPic.setPage(new Page<>(request, response));
		Page<MallPic> page = mallPicService.findPage(mallPic);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallpic:mallPic:view")
	@RequestMapping(value = "form")
	public String form(MallPic mallPic, Model model) {
		model.addAttribute("mallPic", mallPic);
		MallSale mallSale=new MallSale();
		    mallSale.setId("15");
		    mallSale.setOpenId("abcdefg");
	        mallSale.setName("全部");
	        List<MallSale> saleList=mallSaleService.findList(new MallSale());
	        saleList.add(0, mallSale);
        model.addAttribute("sales", saleList);
		return "modules/mallpic/mallPicForm";
	}

	/**
	 * 保存图片
	 */
	@RequiresPermissions("mallpic:mallPic:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallPic mallPic) {
		mallPicService.save(mallPic);
		return renderResult(Global.TRUE, text("保存图片成功！"));
	}
	
	/**
	 * 删除图片
	 */
	@RequiresPermissions("mallpic:mallPic:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallPic mallPic) {
		mallPicService.delete(mallPic);
		return renderResult(Global.TRUE, text("删除图片成功！"));
	}
	
}