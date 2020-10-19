package com.harigroup.hypermarket.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.IHotGoodsQueryService;

/**
 * 商品查询，热销榜单查询
 * 
 * @author 13597
 *
 */
@RestController
public class HotGoodsQueryController {
	
	@Autowired
	private IHotGoodsQueryService queryService;
	@Autowired
	private ResultMap resultMap;
	
	/**
	 * 
	 * 
	 * @return
	 */
	@GetMapping("/hotGoodsQuery")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap hotGoodsQuery() {
		return resultMap.success().message(queryService.hotGoodsQuery());
	}
	
	@GetMapping("/topList")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap topList() {
		return resultMap.success().message(queryService.topList());
	}
}
