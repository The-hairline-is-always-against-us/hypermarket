package com.harigroup.hypermarket.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.ShoppingCar;
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
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
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
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
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
	
	@GetMapping("/getShoppingCar")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getShoppingCar(@RequestHeader String token) {
		List<ShoppingCar> showBCGoods = bcService.showBCGoods(JWTUtil.getUserID(token));

		if (showBCGoods != null) {
			return resultMap.success().message(showBCGoods);
		} else {
			return resultMap.fail().message(showBCGoods);
		}
	}
	
	@PostMapping("/updateBCNumber")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap updateBCGoodsNumber(@RequestHeader String token,@RequestParam("g_id") String g_id,
			@RequestParam("c_id") String c_id,@RequestParam("c_number") String c_number) {
		bcService.updateBCGoodsNumber(Integer.parseInt(g_id), Integer.parseInt(c_id), 
				JWTUtil.getUserID(token), Integer.parseInt(c_number));
		return resultMap.success().message("");
	}

}
