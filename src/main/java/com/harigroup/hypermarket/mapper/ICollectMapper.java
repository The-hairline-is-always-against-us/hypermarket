package com.harigroup.hypermarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.Collect;

/**
 * 收藏
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
	Integer validatecollectGoods(Integer g_id);
}
