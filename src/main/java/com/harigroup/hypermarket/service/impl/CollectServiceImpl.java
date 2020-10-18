package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.ICollectMapper;
import com.harigroup.hypermarket.pojo.Collect;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.service.ICollectService;

@Service
public class CollectServiceImpl implements ICollectService {
	
	@Autowired
	private ICollectMapper collectMapper;

	@Override
	public Integer Collection(Collect collect) {
		return collectMapper.collection(collect);
	}

	@Override
	public Integer validatecollectGoods(Integer g_id,Integer u_id) {
		return collectMapper.validatecollectGoods(g_id,u_id);
	}

	@Override
	public List<Goods> showcollectGoods(int u_id) {
		return collectMapper.showcollectGoods(u_id);
	}

	@Override
	public Integer deleteCollectGoods(Integer g_id) {
		return collectMapper.deleteCollectGoods(g_id);
	}

}
