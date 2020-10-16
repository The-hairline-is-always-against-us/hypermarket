package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IHotGoodsQueryMapper;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.service.IHotGoodsQueryService;

/**
 * Service层实现类
 * 
 * @author 13597
 *
 */
@Service
public class IHotGoodsQueryServiceImpl implements IHotGoodsQueryService {
	
	@Autowired
	private IHotGoodsQueryMapper mapper;

	@Override
	public List<Goods> hotGoodsQuery() {
		return mapper.hotGoodsQuery();
	}

	@Override
	public List<Goods> topList() {
		return mapper.topList();
	}

}
