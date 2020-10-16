package com.harigroup.hypermarket.mapper;

import java.util.List;

import com.harigroup.hypermarket.pojo.Goods;

/**
 * 热门商品以及最新发布查询
 * 
 * @author 13597
 *
 */
public interface IHotGoodsQueryMapper {
	
	/**
	 * 热门商品查询
	 * @return
	 */
	List<Goods> hotGoodsQuery();
	
	/**
	 * 最新发布查询
	 * @return
	 */
	List<Goods> topList();
}
