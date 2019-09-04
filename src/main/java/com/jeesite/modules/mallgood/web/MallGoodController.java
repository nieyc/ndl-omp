/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallgood.web;

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
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.mallchannel.entity.MallChannel;
import com.jeesite.modules.mallchannel.service.MallChannelService;
import com.jeesite.modules.mallgood.entity.MallGood;
import com.jeesite.modules.mallgood.service.MallGoodService;
import com.jeesite.modules.mallgoodrelation.entity.MallGoodShopRelation;
import com.jeesite.modules.mallgoodrelation.service.MallGoodShopRelationService;
import com.jeesite.modules.mallplant.entity.MallPlant;
import com.jeesite.modules.mallplant.service.MallPlantService;
import com.jeesite.modules.mallsale.entity.MallSale;
import com.jeesite.modules.mallsale.service.MallSaleService;
import com.jeesite.modules.mallshop.entity.MallShop;
import com.jeesite.modules.mallshop.service.MallShopService;

/**
 * 商品信息Controller
 * @author nieyc
 * @version 2019-08-29
 */
@Controller
@RequestMapping(value = "${adminPath}/mallgood/mallGood")
public class MallGoodController extends BaseController {

	@Autowired
	private MallGoodService mallGoodService;
	
    @Autowired
    private MallShopService mallShopService;
    
    @Autowired
    private MallGoodShopRelationService mallGoodShopRelationService;
    
    @Autowired
    private MallPlantService mallPlantService;
    
    @Autowired
    private MallChannelService mallChannelService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallGood get(String id, boolean isNewRecord) {
		return mallGoodService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallgood:mallGood:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallGood mallGood, Model model) {
		 model.addAttribute("mallGood", mallGood);
		  
	     MallPlant mallPlant=new MallPlant();
	     mallPlant.setId("");
	     mallPlant.setName("全部");
	     List<MallPlant> plantList=mallPlantService.findList(new MallPlant());
	     plantList.add(0, mallPlant);
         model.addAttribute("plants", plantList);
         MallChannel mallChannel=new MallChannel();
         mallChannel.setId("");
         mallChannel.setName("全部");
         List<MallChannel> channelList=mallChannelService.findList(new MallChannel());
         channelList.add(0, mallChannel);
         model.addAttribute("channel",channelList);
		  
		return "modules/mallgood/mallGoodList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallgood:mallGood:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MallGood> listData(MallGood mallGood, HttpServletRequest request, HttpServletResponse response) {
		mallGood.setPage(new Page<>(request, response));
		Page<MallGood> page = mallGoodService.findPage(mallGood);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallgood:mallGood:view")
	@RequestMapping(value = "form")
	public String form(MallGood mallGood, Model model) {
	    if(StringUtils.isNotEmpty(mallGood.getId())) {
	         MallGoodShopRelation entity=new MallGoodShopRelation();
	         entity.setGoodId(mallGood.getId());
	         List<MallGoodShopRelation> relationList=  mallGoodShopRelationService.findList(entity);
	         String shops="";
	         if(relationList.size()>0) {
	             for(int i=0;i<relationList.size();i++) {
	                 MallGoodShopRelation e=(MallGoodShopRelation)relationList.get(i);
	                 shops+=e.getShopCode()+",";
	             }
	             if(shops.endsWith(",")) {
	                 shops=shops.substring(0,shops.length()-1);
	             }
	             System.out.println("shops:"+shops);
	             mallGood.setSaleFlag(shops);
	         }
	        
	    }
	    
		 model.addAttribute("mallGood", mallGood);
		 MallShop mallShop=new MallShop();
		 mallShop.setTreeCode("0");
		 mallShop.setTreeName("全部");
         List<MallShop> shopList=mallShopService.getLastLevelShop();
         shopList.add(0, mallShop);
         model.addAttribute("shops", shopList);
         List<MallPlant> plantList=mallPlantService.findList(new MallPlant());
         model.addAttribute("plants", plantList);
         List<MallChannel> channelList=mallChannelService.findList(new MallChannel());
         model.addAttribute("channel",channelList);
		 return "modules/mallgood/mallGoodForm";
	}

	/**
	 * 保存商品信息
	 */
	@RequiresPermissions("mallgood:mallGood:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallGood mallGood) {
		mallGoodService.save(mallGood);
		return renderResult(Global.TRUE, text("保存商品信息成功！"));
	}
	
	/**
	 * 删除商品信息
	 */
	@RequiresPermissions("mallgood:mallGood:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallGood mallGood) {
		mallGoodService.delete(mallGood);
		return renderResult(Global.TRUE, text("删除商品信息成功！"));
	}
	
}