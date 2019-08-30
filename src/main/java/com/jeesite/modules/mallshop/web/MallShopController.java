/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.mallshop.web;

import java.util.List;
import java.util.Map;

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
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.mallsale.entity.MallSale;
import com.jeesite.modules.mallsale.service.MallSaleService;
import com.jeesite.modules.mallshop.entity.MallShop;
import com.jeesite.modules.mallshop.service.MallShopService;

/**
 * 门店信息Controller
 * @author nieyc
 * @version 2019-08-27
 */
@Controller
@RequestMapping(value = "${adminPath}/mallshop/mallShop")
public class MallShopController extends BaseController {

	@Autowired
	private MallShopService mallShopService;
	
	@Autowired
	private MallSaleService mallSaleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MallShop get(String treeCode, boolean isNewRecord) {
		return mallShopService.get(treeCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("mallshop:mallShop:view")
	@RequestMapping(value = {"list", ""})
	public String list(MallShop mallShop, Model model) {
		model.addAttribute("mallShop", mallShop);
		MallSale mallSale=new MallSale();
        List<MallSale> saleList=mallSaleService.findList(mallSale);
        model.addAttribute("sales", saleList);
		return "modules/mallshop/mallShopList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("mallshop:mallShop:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<MallShop> listData(MallShop mallShop) {
		if (StringUtils.isBlank(mallShop.getParentCode())) {
			mallShop.setParentCode(MallShop.ROOT_CODE);
		}
		if (StringUtils.isNotBlank(mallShop.getTreeName())){
			mallShop.setParentCode(null);
		}
		if (StringUtils.isNotBlank(mallShop.getPhone())){
			mallShop.setParentCode(null);
		}
		if (StringUtils.isNotBlank(mallShop.getUserName())){
			mallShop.setParentCode(null);
		}
		if (StringUtils.isNotBlank(mallShop.getSaleManId())){
            mallShop.setParentCode(null);
        }
		//List<MallShop> list = mallShopService.findList(mallShop);
		List<MallShop> list = mallShopService.getMallShopList(mallShop);
		return list;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("mallshop:mallShop:view")
	@RequestMapping(value = "form")
	public String form(MallShop mallShop, Model model) {
		// 创建并初始化下一个节点信息
		mallShop = createNextNode(mallShop);
		model.addAttribute("mallShop", mallShop);
		MallSale mallSale=new MallSale();
		List<MallSale> saleList=mallSaleService.findList(mallSale);
		model.addAttribute("sales", saleList);
		return "modules/mallshop/mallShopForm";
	}
	
	/**
	 * 创建并初始化下一个节点信息，如：排序号、默认值
	 */
	@RequiresPermissions("mallshop:mallShop:edit")
	@RequestMapping(value = "createNextNode")
	@ResponseBody
	public MallShop createNextNode(MallShop mallShop) {
		if (StringUtils.isNotBlank(mallShop.getParentCode())){
			mallShop.setParent(mallShopService.get(mallShop.getParentCode()));
		}
		if (mallShop.getIsNewRecord()) {
			MallShop where = new MallShop();
			where.setParentCode(mallShop.getParentCode());
			MallShop last = mallShopService.getLastByParentCode(where);
			// 获取到下级最后一个节点
			if (last != null){
				mallShop.setTreeSort(last.getTreeSort() + 30);
				mallShop.setTreeCode(IdGen.nextCode(last.getTreeCode()));
			}else if (mallShop.getParent() != null){
				mallShop.setTreeCode(mallShop.getParent().getTreeCode() + "001");
			}
		}
		// 以下设置表单默认数据
		if (mallShop.getTreeSort() == null){
			mallShop.setTreeSort(MallShop.DEFAULT_TREE_SORT);
		}
		return mallShop;
	}

	/**
	 * 保存门店信息
	 */
	@RequiresPermissions("mallshop:mallShop:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MallShop mallShop) {
		mallShopService.save(mallShop);
		return renderResult(Global.TRUE, text("保存门店信息成功！"));
	}
	
	/**
	 * 删除门店信息
	 */
	@RequiresPermissions("mallshop:mallShop:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MallShop mallShop) {
		mallShopService.delete(mallShop);
		return renderResult(Global.TRUE, text("删除门店信息成功！"));
	}
	
	/**
	 * 获取树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequiresPermissions("mallshop:mallShop:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, String isShowCode) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<MallShop> list = mallShopService.findList(new MallShop());
		for (int i=0; i<list.size(); i++){
			MallShop e = list.get(i);
			// 过滤非正常的数据
			if (!MallShop.STATUS_NORMAL.equals(e.getStatus())){
				continue;
			}
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotBlank(excludeCode)){
				if (e.getId().equals(excludeCode)){
					continue;
				}
				if (e.getParentCodes().contains("," + excludeCode + ",")){
					continue;
				}
			}
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentCode());
			map.put("name", StringUtils.getTreeNodeName(isShowCode, e.getTreeCode(), e.getTreeName()));
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 修复表结构相关数据
	 */
	@RequiresPermissions("mallshop:mallShop:edit")
	@RequestMapping(value = "fixTreeData")
	@ResponseBody
	public String fixTreeData(MallShop mallShop){
		if (!UserUtils.getUser().isAdmin()){
			return renderResult(Global.FALSE, "操作失败，只有管理员才能进行修复！");
		}
		mallShopService.fixTreeData();
		return renderResult(Global.TRUE, "数据修复成功");
	}
	
}