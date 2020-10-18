package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.Orderform;
import com.harigroup.hypermarket.pojo.ResultMap;
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
	
	
	/**
	 * 查询某个用户的订单
	 * 
	 * @param u_id 用户ID
	 * @return
	 */
	@PostMapping("/selectOrders")
	public ResultMap selectOrders(@RequestHeader String token) {
		int u_id = JWTUtil.getUserID(token);
		return resultMap.success().message(orderService.getAllOrder(String.valueOf(u_id)));
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
		Orderform parseObject = JSON.parseObject(order,Orderform.class);
		System.out.println(parseObject);
		int u_id = JWTUtil.getUserID(token);
		parseObject.setU_id(u_id);
		return resultMap.success().message(orderService.releaseOrder(parseObject));
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
