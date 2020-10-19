package com.harigroup.hypermarket.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.Store;
import com.harigroup.hypermarket.service.IStoreService;
import com.harigroup.hypermarket.utils.JWTUtil;

@RestController
public class StoreController {

	@Autowired
	private IStoreService storeService;
	@Autowired
	private ResultMap resultMap;
	
	/**
	 * 提出申请开店铺
	 * s_name(店铺名称)  reqest_time(申请时间) s_intro(简介)  s_status(状态)
	 * @param s
	 * @return
	 */
	@PostMapping("/applyStore")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap applyStore(@RequestParam("store") String s,@RequestHeader String token) {
		Store store = JSON.parseObject(s,Store.class);
		store.setU_id(JWTUtil.getUserID(token));
		Integer applyStore = storeService.applyStore(store);
		if(applyStore>0) {
			return resultMap.success().message("提交申请成功");
		}else {
			return resultMap.fail().message("提交申请失败");
		}
	}
	
	/**
	 * 管理员批准申请
	 * create_time(批准时间) s_status(状态)
	 * @param s
	 * @return
	 */
	@PostMapping("/passApply")
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
	public ResultMap passApply(@RequestParam("store") String s) {
		Store store = JSON.parseObject(s,Store.class);
		Integer applyStore = storeService.passApply(store);
		if(applyStore>0) {
			return resultMap.success().message("店铺申请成功");
		}else {
			return resultMap.fail().message("店铺申请失败");
		}
	}
	
	/**
	 * 查看店铺(根据卖家ID查看所有店铺信息)
	 * @param u_id
	 * @return
	 */
	@PostMapping("/getStoreByUid")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getStoreByUid(@RequestHeader("token") String token) {
		Integer uId=JWTUtil.getUserID(token);
	//public ResultMap getStoreByUid(@RequestParam("u_id") String u_id) {
//		Integer uId=Integer.parseInt(u_id);
		return resultMap.success().message(storeService.getStoreByUid(uId));
	}
	
	/**
	 * 查看店铺详情
	 * @param s_id
	 * @return
	 */
	@PostMapping("/getStoreBySid")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getStoreBySid(@RequestParam("s_id") String s_id) {
		Integer sId=Integer.parseInt(s_id);
		return resultMap.success().message(storeService.getStoreBySid(sId));
	}
	
	/**
	 * 取店铺申请
	 * @param s_id
	 * @return
	 */
	@PostMapping("/deleteStoreBySid")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap deleteStoreBySid(@RequestParam("s_id") String s_id) {
		Integer sId=Integer.parseInt(s_id);
		Integer deleteStore = storeService.deleteStore(sId);
		if(deleteStore>0) {
			return resultMap.success().message("删除成功");
		}
		return resultMap.fail().message("删除失败");
	}
	
	@GetMapping("/getAllStore/{pageIndex}/{pageSize}")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getAllStore(@PathVariable String pageIndex,@PathVariable String pageSize) {
		PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		List<Store> allStore = storeService.getAllStore();
		PageInfo<Store> info = new PageInfo<>(allStore);
		return resultMap.success().message(allStore).addElement("total", info.getTotal());
	}
	
	@GetMapping("/getAllPStore/{pageIndex}/{pageSize}")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getAllPStore(@PathVariable String pageIndex,@PathVariable String pageSize) {
		PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		List<Store> allPStore = storeService.getAllPStore();
		PageInfo<Store> info = new PageInfo<>(allPStore);
		return resultMap.success().message(allPStore).addElement("total", info.getTotal());
	}
}
