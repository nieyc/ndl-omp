/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallsale.web;

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
import com.jeesite.modules.mallsale.entity.MallSale;
import com.jeesite.modules.mallsale.service.MallSaleService;

/**
 * mall_saleController
 * @author nieyc
 * @version 2019-08-29
 */
@Controller
@RequestMapping(value = "${adminPath}/mallsale/mallSale")
public class MallSaleController extends BaseController {

	@Autowired
	private MallSaleService mallSaleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallSale get(String id, boolean isNewRecord) {
		return mallSaleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallsale:mallSale:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallSale mallSale, Model model) {
		model.addAttribute("mallSale", mallSale);
		return "modules/mallsale/mallSaleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallsale:mallSale:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallSale> listData(MallSale mallSale, HttpServletRequest request, HttpServletResponse response) {
		mallSale.setPage(new Page<>(request, response));
		Page<MallSale> page = mallSaleService.findPage(mallSale);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallsale:mallSale:view")
	@RequestMapping(value = "form")
	public String form(MallSale mallSale, Model model) {
		model.addAttribute("mallSale", mallSale);
		return "modules/mallsale/mallSaleForm";
	}

	/**
	 * 保存mall_sale
	 */
	@RequiresPermissions("mallsale:mallSale:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallSale mallSale) {
		mallSaleService.save(mallSale);
		return renderResult(Global.TRUE, text("保存业务员成功！"));
	}
	
	/**
	 * 删除mall_sale
	 */
	@RequiresPermissions("mallsale:mallSale:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallSale mallSale) {
		mallSaleService.delete(mallSale);
		return renderResult(Global.TRUE, text("删除业务员成功！"));
	}
	
}