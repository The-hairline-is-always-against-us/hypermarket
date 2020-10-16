package com.harigroup.hypermarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.ICollectMapper;
import com.harigroup.hypermarket.pojo.Collect;
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
	public Integer validatecollectGoods(Integer g_id) {
		return collectMapper.validatecollectGoods(g_id);
	}

}
