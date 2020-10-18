package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IOrderMapper;
import com.harigroup.hypermarket.pojo.Orderform;
import com.harigroup.hypermarket.pojo.ShoppingCar;
import com.harigroup.hypermarket.service.IOrderService;

/**
 * 订单的对应的接口实现类
 * 
 * 主要方法有：获取对应用户的全部订单
 *         删除指定订单功能
 *         添加一个订单功能
 * 
 * @author asus
 *
 */
@Service
public class OrderServiceImpl implements IOrderService{

	
	@Autowired
	private IOrderMapper orderMapper;
	
	
	@Override
	public List<ShoppingCar> getAllOrder(String u_id){
		// TODO Auto-generated method stub
		return orderMapper.getAllOrder(u_id);
	}


	@Override
	public Integer delOrderById(Integer o_id) {
		// TODO Auto-generated method stub
		return orderMapper.delOrderById(o_id);
	}

	@Override
	public Integer releaseOrder(Orderform order) {
		// TODO Auto-generated method stub
		return orderMapper.releaseOrder(order);
	}
	
	
	
	
}
