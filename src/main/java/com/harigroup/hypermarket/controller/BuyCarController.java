package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.BuyCar;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.IBuyCarService;
import com.harigroup.hypermarket.utils.JWTUtil;

@RestController
public class BuyCarController {

	// 自动注入 默认为单例模式
	@Autowired
	private IBuyCarService bcService;
	@Autowired
	private ResultMap resultMap;

	/**
	 * 将商品加入购物车
	 */
	@PostMapping("/addbuycar")
	public ResultMap addbuycar(@RequestParam("g_id") String g_id, @RequestHeader String token) {
		
		Integer x1 = JWTUtil.getUserID(token);
		Integer x2 = Integer.parseInt(g_id);

		Integer fg = bcService.findGoods(x1, x2);

		if (fg != null && fg > 0) {
			Integer upg = bcService.upBCGoods(JWTUtil.getUserID(token), Integer.valueOf(g_id));

			if (upg > 0) {
				return resultMap.success().message(upg);
			} else {
				return resultMap.fail().message(upg);
			}

		} else {
			Integer addg = bcService.buyCar(JWTUtil.getUserID(token), Integer.valueOf(g_id));

			if (addg > 0) {
				return resultMap.success().message(addg);
			} else {
				return resultMap.fail().message(addg);
			}
		}

	}

	/**
	 * 删除/减少购物车中的商品数量
	 * @param g_id
	 * @param token
	 * @return
	 */
	@PostMapping("/deletebuycar")
	public ResultMap deleteGoods(@RequestParam("g_id") String g_id, @RequestHeader String token) {

		Integer fg = bcService.findGoods(JWTUtil.getUserID(token), Integer.valueOf(g_id));

		if (fg > 1) {
			Integer dwg = bcService.downBCGoods(JWTUtil.getUserID(token), Integer.valueOf(g_id));

			if (dwg > 0) {
				return resultMap.success().message(dwg);
			} else {
				return resultMap.fail().message(dwg);
			}

		} else {

			Integer addg = bcService.buyCar(JWTUtil.getUserID(token), Integer.valueOf(g_id));

			if (addg > 0) {
				return resultMap.success().message(addg);
			} else {
				return resultMap.fail().message(addg);
			}
		}

	}

}
