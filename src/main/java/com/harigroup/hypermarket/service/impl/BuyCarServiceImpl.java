package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IBuyCarMapper;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.pojo.ShoppingCar;
import com.harigroup.hypermarket.service.IBuyCarService;

@Service
public class BuyCarServiceImpl implements IBuyCarService {

	@Autowired
	private IBuyCarMapper ibcMapper;

	@Override
	public Integer buyCar(Integer u_id, Integer g_id) {
		return ibcMapper.buyCar(u_id, g_id);
	}

	@Override
	public Integer deleteBCGoods(Integer u_id, Integer g_id) {
		return ibcMapper.deleteBCGoods(u_id, g_id);
	}

	@Override
	public Integer findGoods(Integer u_id, Integer g_id) {
		return ibcMapper.findGoods(u_id, g_id);
	}

	@Override
	public Integer downBCGoods(Integer u_id, Integer g_id) {
		return ibcMapper.downBCGoods(u_id, g_id);
	}

	@Override
	public Integer upBCGoods(Integer u_id, Integer g_id) {
		return ibcMapper.upBCGoods(u_id, g_id);
	}

	@Override
	public List<ShoppingCar> showBCGoods(int u_id) {
		return ibcMapper.showBCGoods(u_id);
	}
	
	


}
