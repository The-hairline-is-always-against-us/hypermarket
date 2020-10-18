package com.harigroup.hypermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.Orderform;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.ShoppingCar;
import com.harigroup.hypermarket.service.IBuyCarService;
import com.harigroup.hypermarket.service.IOrderService;
import com.harigroup.hypermarket.utils.JWTUtil;

/**
 * 订单相关功能
 * 
 * @author asus
 *
 */

@RestController
public class IOrderController {
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private ResultMap resultMap;
	@Autowired
	private IBuyCarService buyCarService;
	
	
	/**
	 * 查询某个用户的订单
	 * 
	 * @param u_id 用户ID
	 * @return
	 */
	@GetMapping("/selectOrders")
	public ResultMap selectOrders(@RequestHeader String token) {
		int u_id = JWTUtil.getUserID(token);
		
		List<ShoppingCar> showBCGoods = orderService.getAllOrder(String.valueOf(u_id));
		
		return resultMap.success().message(showBCGoods);
	}

	/**
	 * 某个用户下达订单
	 * 
	 * @param order
	 * @param token
	 * @return
	 */
	@PostMapping("/releaseOrders")
	public ResultMap releaseOrders(@RequestParam("order") String order,@RequestHeader String token) {
		ShoppingCar parseObject = JSON.parseObject(order,ShoppingCar.class);
		Orderform orderform = new Orderform();
		orderform.setU_id(JWTUtil.getUserID(token));
		orderform.setG_id(parseObject.getG_id());
		orderform.setO_number(parseObject.getC_number());
		orderform.setPrice(Double.valueOf(parseObject.getG_price()));
		buyCarService.deleteBCGoods(JWTUtil.getUserID(token), parseObject.getG_id());
		return resultMap.success().message(orderService.releaseOrder(orderform));
	}
	
	/**
	 * 删除指定订单功能
	 * 
	 * @param o_id
	 * @param token
	 * @return
	 */
	@PostMapping("/delOrderById")
	public ResultMap delOrderById(@RequestParam("o_id") String o_id, @RequestHeader String token ) {
		Integer oId=Integer.parseInt(o_id);
		Integer order = orderService.delOrderById(oId);
		
		if(order == null) {
			return resultMap.fail().message("您的订单列表没有订单!");
		}else {
			return resultMap.success().message("成功删除订单!");
		}
		
	}

}
