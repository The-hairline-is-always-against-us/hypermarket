package com.harigroup.hypermarket.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.Collect;
import com.harigroup.hypermarket.pojo.Goods;

/**
 * 收藏功能
 * @author LiuBo
 *
 */

public interface ICollectMapper extends BaseMapper<Collect>{
	
	/**
	 * 收藏
	 */
	Integer collection(Collect collect);
	
	/**
	 * 根据物品id查询是否收藏过该物品
	 * @param g_id
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
	Integer deleteCollectGoods(Integer g_id,Integer u_id);
}
