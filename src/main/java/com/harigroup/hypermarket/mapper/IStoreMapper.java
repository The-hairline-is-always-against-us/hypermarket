package com.harigroup.hypermarket.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.Store;

public interface IStoreMapper extends BaseMapper<Store> {
	
	
	/**
	 * 根据店铺ID查询店铺信息详情的DAO接口
	 * @return
	 */
	Store getStoreBySid(Integer s_id);
	
	/**
	 * 根据卖家ID查询该卖家的所有店铺信息的DAO接口
	 * @param u_id
	 * @return
	 */
	List<Store> getStoreByUid(Integer u_id);
	/**
	 * 店铺申请的DAO接口
	 * @param store
	 * @return
	 */
	Integer applyStore(Store store);
	
	/**
	 * 管理员批准店铺申请的DAO接口
	 * @param store
	 * @return
	 */
	Integer passApply(Store store);
	
	/**
	 * 根据商铺ID删除商品的DAO接口
	 * @param s_id
	 * @return
	 */
	Integer deleteStore(Integer s_id);
	
	/**
	 * 获取该商铺的营销额的DAO接口
	 * @param s_id
	 * @return
	 */
	Integer salesCount(Integer s_id);

}
