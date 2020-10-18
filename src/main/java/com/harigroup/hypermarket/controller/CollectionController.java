package com.harigroup.hypermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.Collect;
import com.harigroup.hypermarket.pojo.Goods;
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
			parseObject.setU_id(JWTUtil.getUserID(token));
			Integer collection = collectService.Collection(parseObject);
			return resultMap.success().message(collection);
		}

		/**
		 * 验证商品是否存在
		 * @param g_id 商品ID
		 * @return
		 */
		@GetMapping("/validategoods/{g_id}")
		public ResultMap validateUsername(@PathVariable("g_id") Integer g_id,@RequestHeader String token) {
			Integer validatecollectGoods = collectService.validatecollectGoods(g_id,JWTUtil.getUserID(token));
			if (validatecollectGoods > 0) {
				return resultMap.fail().message("已收藏，别再重复收藏啦");
			} else {
				return resultMap.success().message("收藏成功！");
			}
		}
		
		/**
		 * 展示收藏商品
		 * @param u_id
		 * @return
		 */
		@GetMapping("/collectall/{u_id}")
		public List<Goods> collectGoods(@PathVariable("u_id") Integer u_id) {
			List<Goods> showcollectGoods = collectService.showcollectGoods(u_id);
			if (showcollectGoods.size() > 0) {
				return showcollectGoods;
			} else {
				return null;
			}
		}
		
		/**
		 * 删除收藏的商品
		 * @param g_id
		 * @return
		 */
		@GetMapping("/delete/{g_id}")
		public ResultMap deleteCollectGoods(@PathVariable("g_id") Integer g_id) {
			Integer dcg = collectService.deleteCollectGoods(g_id);
			if(dcg>0) {
				return resultMap.success().message("删除成功");
			}else {
				return resultMap.fail().message("删除失败，请稍后再试！");
			}
		}
		
}
