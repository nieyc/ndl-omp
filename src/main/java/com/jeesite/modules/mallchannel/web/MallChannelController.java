/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallchannel.web;

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
import com.jeesite.modules.mallchannel.entity.MallChannel;
import com.jeesite.modules.mallchannel.service.MallChannelService;

/**
 * 产品分类Controller
 * @author nieyc
 * @version 2019-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/mallchannel/mallChannel")
public class MallChannelController extends BaseController {

	@Autowired
	private MallChannelService mallChannelService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallChannel get(String id, boolean isNewRecord) {
		return mallChannelService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallchannel:mallChannel:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallChannel mallChannel, Model model) {
		model.addAttribute("mallChannel", mallChannel);
		return "modules/mallchannel/mallChannelList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallchannel:mallChannel:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallChannel> listData(MallChannel mallChannel, HttpServletRequest request, HttpServletResponse response) {
		mallChannel.setPage(new Page<>(request, response));
		Page<MallChannel> page = mallChannelService.findPage(mallChannel);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallchannel:mallChannel:view")
	@RequestMapping(value = "form")
	public String form(MallChannel mallChannel, Model model) {
		model.addAttribute("mallChannel", mallChannel);
		return "modules/mallchannel/mallChannelForm";
	}

	/**
	 * 保存产品分类
	 */
	@RequiresPermissions("mallchannel:mallChannel:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallChannel mallChannel) {
		mallChannelService.save(mallChannel);
		return renderResult(Global.TRUE, text("保存产品分类成功！"));
	}
	
	/**
	 * 删除产品分类
	 */
	@RequiresPermissions("mallchannel:mallChannel:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallChannel mallChannel) {
		mallChannelService.delete(mallChannel);
		return renderResult(Global.TRUE, text("删除产品分类成功！"));
	}
	
}