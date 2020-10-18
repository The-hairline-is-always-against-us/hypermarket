package com.harigroup.hypermarket.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.Orderform;

/**
 * 订单相关的DAO层操作
 * 
 * @author asus
 *
 */
public interface IOrderMapper extends BaseMapper<Orderform>{

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
	 *  添加一个订单功能
	 * 
	 * @param order
	 * @return
	 */
	Integer releaseOrder(Orderform order);

	
}
