/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallplant.web;

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
import com.jeesite.modules.mallplant.entity.MallPlant;
import com.jeesite.modules.mallplant.service.MallPlantService;

/**
 * 植物分类Controller
 * @author nieyc
 * @version 2019-08-31
 */
@Controller
@RequestMapping(value = "${adminPath}/mallplant/mallPlant")
public class MallPlantController extends BaseController {

	@Autowired
	private MallPlantService mallPlantService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallPlant get(String id, boolean isNewRecord) {
		return mallPlantService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallplant:mallPlant:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallPlant mallPlant, Model model) {
		model.addAttribute("mallPlant", mallPlant);
		return "modules/mallplant/mallPlantList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallplant:mallPlant:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallPlant> listData(MallPlant mallPlant, HttpServletRequest request, HttpServletResponse response) {
		mallPlant.setPage(new Page<>(request, response));
		Page<MallPlant> page = mallPlantService.findPage(mallPlant);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallplant:mallPlant:view")
	@RequestMapping(value = "form")
	public String form(MallPlant mallPlant, Model model) {
		model.addAttribute("mallPlant", mallPlant);
		return "modules/mallplant/mallPlantForm";
	}

	/**
	 * 保存植物分类
	 */
	@RequiresPermissions("mallplant:mallPlant:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallPlant mallPlant) {
		mallPlantService.save(mallPlant);
		return renderResult(Global.TRUE, text("保存植物分类成功！"));
	}
	
	/**
	 * 删除植物分类
	 */
	@RequiresPermissions("mallplant:mallPlant:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallPlant mallPlant) {
		mallPlantService.delete(mallPlant);
		return renderResult(Global.TRUE, text("删除植物分类成功！"));
	}
	
}