package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.Collect;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.ICollectService;
import com.harigroup.hypermarket.utils.JWTUtil;

@RestController
public class CollectionController {

	// 自动注入 默认为单例模式
	@Autowired
	private ICollectService collectService;
	@Autowired
	private ResultMap resultMap;

	/**
	 * 收藏方法 —— 点击收藏，查询收藏表中是否已存在该商品 => 若不存在，则将该商品加入收藏表。若存在，提示用户，该商品已存在。
	 * @param collect 收藏商品的信息
	 * @return
	 */
	@PostMapping("/collect")
	public ResultMap collect(@RequestParam("collect") String collect,@RequestHeader String token) {
		Collect parseObject = JSON.parseObject(collect,Collect.class);
		System.out.println(token);
		parseObject.setU_id(JWTUtil.getUserID(token));
		Integer collection = collectService.Collection(parseObject);
		return resultMap.success().message(collection);
	}

	/**
	 * 验证商品是否存在
	 * @param g_id 商品ID
	 * @return
	 */
	@GetMapping("/validateu/{g_id}")
	public ResultMap validateUsername(@PathVariable("g_id") Integer g_id) {
		Integer validatecollectGoods = collectService.validatecollectGoods(g_id);
		if (validatecollectGoods > 0) {
			return resultMap.fail().message("已收藏，别再重复收藏啦");
		} else {
			return resultMap.success().message("收藏成功！");
		}
	}
}
