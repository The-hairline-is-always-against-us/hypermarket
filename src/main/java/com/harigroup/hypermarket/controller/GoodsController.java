package com.harigroup.hypermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.IGoodsService;

@RestController
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private ResultMap resultMap;
	
	
	@PostMapping("/getGoodsByTname")
	public ResultMap getGoodsByTname(@RequestParam("t_name") String t_name) {
		List<Goods> goods = goodsService.getGoodsByTName(t_name);
		if(goods==null) {
			return resultMap.fail().message("该类别没有商品");
		}else {
			return resultMap.success().message(goods);
		}
	}
	
	@PostMapping("/getGoods")
	public ResultMap getGoods() {
		return resultMap.success().message(goodsService.getGoods());
	}
	
	@PostMapping("/insertGoods")
	public ResultMap insertGoods(@RequestParam("goods") Goods goods) {
		goodsService.insertGoods(goods);
		return resultMap.success().message("");
	}

}
