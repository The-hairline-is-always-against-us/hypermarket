package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IGoodsMapper;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private IGoodsMapper goodsMapper;

	@Override
	public Integer insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insertGoods(goods);
	}

	@Override
	public List<Goods> getGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.getGoods();
	}

	@Override
	public Goods getGoodsByGid(Integer g_id) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsByGid(g_id);
	}

	@Override
	public List<Goods> getGoodsByGname(String g_name) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsByGname(g_name);
	}

	@Override
	public List<Goods> getGoodsByTName(String t_name) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsByTName(t_name);
	}

	@Override
	public Integer deleteGoods(Integer g_id) {
		// TODO Auto-generated method stub
		return goodsMapper.deleteGoods(g_id);
	}
	

}
