package com.harigroup.hypermarket.service;

import java.util.List;

import com.harigroup.hypermarket.pojo.BuyCar;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.pojo.ShoppingCar;

public interface IBuyCarService {


	/**
	 * 购物车接口
	 * 
	 * @param BuyCar 封装商品类
	 * @return
	 */
	Integer buyCar(Integer u_id,Integer g_id);

	/**
	 * 删除购物车中的商品
	 */
	Integer deleteBCGoods(Integer u_id,Integer g_id);

	/**
	 * 根据用户id展示收藏的商品
	 * 
	 * @param u_id
	 * @return
	 */
	List<ShoppingCar> showBCGoods(int u_id);
	
	/**
	 * 查询购物车中该商品的数量
	 * @param g_id
	 * @return
	 */
	Integer findGoods(Integer u_id,Integer g_id);
	
	/**
	 * 减少购物车中的某种商品
	 * @param g_id
	 * @return
	 */
	Integer downBCGoods(Integer u_id,Integer g_id);
	
	/**
	 * 增加购物车中的某种商品
	 * @param g_id
	 * @return
	 */
	Integer upBCGoods(Integer u_id,Integer g_id);

	
}
