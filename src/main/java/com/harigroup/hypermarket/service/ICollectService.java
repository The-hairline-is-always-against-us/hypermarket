package com.harigroup.hypermarket.service;

import java.util.List;

import com.harigroup.hypermarket.pojo.Collect;
import com.harigroup.hypermarket.pojo.Goods;

public interface ICollectService {
	
	/**
	 * 收藏商品接口
	 * @param collect 封装收藏的商品类
	 * @return
	 */
	Integer Collection(Collect collect);

	/**
	 * 表单验证（商品ID验证）后端查询DAO接口
	 * @param g_id 商品ID
	 * @return 数据库中存在的数量
	 * @return 
	 */
	Integer validatecollectGoods(Integer g_id,Integer u_id);
	
	/**
	 * 根据用户id展示收藏的商品
	 * @param u_id
	 * @return
	 */
	List<Goods> showcollectGoods(int u_id);
	
	/**
	 * 删除收藏的商品
	 * @param g_id
	 * @return
	 */
	Integer deleteCollectGoods(Integer g_id);
}
