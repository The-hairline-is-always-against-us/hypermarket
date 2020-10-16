package com.harigroup.hypermarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.ResultMap;

/**
 * 商品查询，热销榜单查询
 * 
 * @author 13597
 *
 */
@RestController
public class HotGoodsQueryController {
	
	@GetMapping("/hotGoodsQuery")
	public ResultMap hotGoodsQuery() {
		return null;
	}
	
	@GetMapping("/topList")
	public ResultMap toList() {
		return null;
	}
}
