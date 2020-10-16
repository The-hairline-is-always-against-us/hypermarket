package com.harigroup.hypermarket.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.Goods;

public interface IGoodsMapper extends BaseMapper<Goods>{
	
	/**
	 * 添加商品信息的DAO接口
	 * @param goods
	 * 		商铺id（u_id)
	 * 		类型id(t_id)
	 * 		商品名(s_name)
	 * 		商品简介(s_intro)
	 * 		商品价格、数量、上架时间、状态
	 * @return
	 */
	Integer insertGoods(Goods goods);

	/**
	 * 查看所有商品的DAO接口
	 * @param g_id
	 * @return
	 */
	List<Goods> getGoods();
	
	/**
	 * 查看商品详情DAO接口
	 * @param g_id
	 * @return
	 */
	Goods getGoodsByGid(Integer g_id);
	
	/**
	 * 根据商品名获取商品信息的DAO接口
	 * @param g_name
	 * @return
	 */
	List<Goods> getGoodsByGname(String g_name);
	
	/**
	 * 根据类别获取商品信息的DAO接口
	 * @param t_name
	 * @return
	 */
	List<Goods> getGoodsByTName(String t_name);
	
	/**
	 * 管理员根据商品id删除数据库中的商品信息的DAO接口
	 * @param g_id
	 * @return
	 * 		>0：删除成功
	 * 		<=0：删除失败
	 */
	Integer deleteGoods(Integer g_id);
	
	
}
