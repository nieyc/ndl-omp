/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgoodattr.web;

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
import com.jeesite.modules.mallgoodattr.entity.MallGoodAttribute;
import com.jeesite.modules.mallgoodattr.service.MallGoodAttributeService;

/**
 * mall_good_attributeController
 * @author nieyc
 * @version 2019-09-03
 */
@Controller
@RequestMapping(value = "${adminPath}/mallgoodattr/mallGoodAttribute")
public class MallGoodAttributeController extends BaseController {

	@Autowired
	private MallGoodAttributeService mallGoodAttributeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallGoodAttribute get(String id, boolean isNewRecord) {
		return mallGoodAttributeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallgoodattr:mallGoodAttribute:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallGoodAttribute mallGoodAttribute, Model model) {
		model.addAttribute("mallGoodAttribute", mallGoodAttribute);
		model.addAttribute("goodId",mallGoodAttribute.getGoodId());
		return "modules/mallgoodattr/mallGoodAttributeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallgoodattr:mallGoodAttribute:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallGoodAttribute> listData(MallGoodAttribute mallGoodAttribute, HttpServletRequest request, HttpServletResponse response) {
		mallGoodAttribute.setPage(new Page<>(request, response));
		Page<MallGoodAttribute> page = mallGoodAttributeService.findPage(mallGoodAttribute);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallgoodattr:mallGoodAttribute:view")
	@RequestMapping(value = "form")
	public String form(MallGoodAttribute mallGoodAttribute, Model model) {
		model.addAttribute("mallGoodAttribute", mallGoodAttribute);
		return "modules/mallgoodattr/mallGoodAttributeForm";
	}

	/**
	 * 保存商品属性
	 */
	@RequiresPermissions("mallgoodattr:mallGoodAttribute:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallGoodAttribute mallGoodAttribute) {
		mallGoodAttributeService.save(mallGoodAttribute);
		return renderResult(Global.TRUE, text("保存商品属性成功！"));
	}
	
	/**
	 * 删除商品属性
	 */
	@RequiresPermissions("mallgoodattr:mallGoodAttribute:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallGoodAttribute mallGoodAttribute) {
		mallGoodAttributeService.delete(mallGoodAttribute);
		return renderResult(Global.TRUE, text("删除商品属性成功！"));
	}
	
}