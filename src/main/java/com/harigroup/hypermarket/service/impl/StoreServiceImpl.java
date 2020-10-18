package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IStoreMapper;
import com.harigroup.hypermarket.pojo.Store;
import com.harigroup.hypermarket.service.IStoreService;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	IStoreMapper storeMapper;
	

	@Override
	public List<Store> getStoreByUid(Integer u_id) {
		// TODO Auto-generated method stub
		return storeMapper.getStoreByUid(u_id);
	}
	
	@Override
	public Integer applyStore(Store store) {
		// TODO Auto-generated method stub
		return storeMapper.applyStore(store);
	}

	@Override
	public Integer passApply(Store store) {
		// TODO Auto-generated method stub
		return storeMapper.passApply(store);
	}

	@Override
	public Store getStoreBySid(Integer s_id) {
		// TODO Auto-generated method stub
		Store store=storeMapper.getStoreBySid(s_id);
		store.setSale_count(storeMapper.salesCount(s_id));
		return store;
	}

	@Override
	public Integer deleteStore(Integer s_id) {
		// TODO Auto-generated method stub
		return storeMapper.deleteStore(s_id);
	}

	@Override
	public List<Store> getAllStore() {
		// TODO Auto-generated method stub
		return storeMapper.getAllStore();
	}

	@Override
	public List<Store> getAllPStore() {
		// TODO Auto-generated method stub
		return storeMapper.getAllPStore();
	}



}
