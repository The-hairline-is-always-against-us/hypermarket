package com.harigroup.hypermarket.service;

import com.harigroup.hypermarket.pojo.Collect;

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
	Integer validatecollectGoods(Integer g_id);

}
