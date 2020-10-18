package com.harigroup.hypermarket.service;

import java.util.List;

import com.harigroup.hypermarket.pojo.Orderform;

/**
 * 订单相关的Service层操作
 * 
 * 功能有：获取对应用户的全部订单
 *      删除指定订单功能
 *      添加一个订单功能
 *      
 * @author asus
 *
 */
public interface IOrderService {
	
	/**
	 * 获取对应用户的全部订单
	 * 
	 * @param u_id
	 * @return
	 */
	List<Orderform> getAllOrder(String u_id);
	
	/**
	 * 删除指定订单功能
	 * 
	 * @param o_id
	 * @return
	 */
	Integer delOrderById(Integer o_id);

	/**
	 * 添加一个订单功能
	 * 
	 * @param order
	 * @return
	 */
	Integer releaseOrder(Orderform order);

}
