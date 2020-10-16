package com.harigroup.hypermarket.service;

import java.util.List;

import com.harigroup.hypermarket.pojo.Goods;

/**
 * Service层
 * 
 * @author 13597
 *
 */
public interface IHotGoodsQueryService {
	/**
	 * 热门商品查询
	 * @return 热门商品集合，数量为7
	 */
	List<Goods> hotGoodsQuery();
	
	/**
	 * 最新发布查询
	 * @return 最新发布热门商品集合，数量为7
	 */
	List<Goods> topList();
}
