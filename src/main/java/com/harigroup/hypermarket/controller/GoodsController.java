package com.harigroup.hypermarket.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harigroup.hypermarket.pojo.Goods;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.Type;
import com.harigroup.hypermarket.service.IGoodsService;
import com.harigroup.hypermarket.utils.MinioUtil;

import io.minio.MinioClient;

@RestController
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private ResultMap resultMap;
	
	/**
	 * 根据商品类型查询商品
	 * @param t_name
	 * @return
	 */
	@PostMapping("/getGoodsByTname")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getGoodsByTname(@RequestParam("t_name") String t_name) {
		List<Goods> goods = goodsService.getGoodsByTName(t_name);
		if(goods==null) {
			return resultMap.fail().message("该类别没有商品");
		}else {
			return resultMap.success().message(goods);
		}
	}
	
	/**
	 * 查询所有商品信息
	 * @return
	 */
	@PostMapping("/getGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getGoods(@RequestParam("pageNumber")String pageNumber,@RequestParam("pageSize") String pageSize) {
		PageHelper.startPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
		List<Goods> goods = goodsService.getGoods();
		PageInfo<Goods> info = new PageInfo<>(goods);
		return resultMap.success().message(goods).addElement("total", info.getTotal());
		
	}
	
	/**
	 * 根据商品名称查询商品
	 * @param g_name
	 * @return
	 */
	@PostMapping("/getGoodsByGname")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getGoodsByGname(@RequestParam("g_name") String g_name) {
		return resultMap.success().message(goodsService.getGoodsByGname(g_name));
	}
	
	/**
	 * 根据商品id查询商品信息详情
	 * @param g_id
	 * @return
	 */
	@PostMapping("/getGoodsByGid")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getGoodsByGid(@RequestParam("g_id") String g_id) {
		int gId=Integer.parseInt(g_id);
		return resultMap.success().message(goodsService.getGoodsByGid(gId));
	}
	/**
	 * 添加商品信息（ 
	 * "t_id":1,
	   "s_id":1,
	   "g_name":"荣耀",
	   "g_intro":"好得不行",
	   "g_price":5432,
	   "g_total":2345,
	   "uptime":"2020-10-09",
	 * @param goodStr
	 * @return
	 */
	@PostMapping("/insertGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap insertGoods(@RequestParam("goods") String goodStr,@RequestParam("file") MultipartFile file) {
		Goods parseObject = JSON.parseObject(goodStr,Goods.class);
		MinioUtil instance = MinioUtil.getInstance();
		String upLoadFile = instance.upLoadFile(file);
		parseObject.setG_picture(upLoadFile);
		goodsService.insertGoods(parseObject);
		return resultMap.success().message("添加成功！");
	}
	
	/**
	 * 管理员彻底删除商品
	 * @param g_id
	 * @return
	 */
	@PostMapping("/deleteGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap deleteGoods(@RequestParam("g_id") String g_id) {
		int gId = Integer.parseInt(g_id);
		Integer deleteGoods = goodsService.deleteGoods(gId);
		if(deleteGoods>0) {
			return resultMap.success().message("删除成功");
		}else {
			return resultMap.fail().message("删除失败");
		}
		
	}
	
	/**
	 * 查看所有商品类型
	 * 在添加商品页面显示，以便添加商品时，直接选择已有商品类型
	 * @return
	 */
	@PostMapping("/getType")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getType() {
		List<Type> type = goodsService.getType();
		if(type==null) {
			return resultMap.fail().message("没有类别");
		}else {
			return resultMap.success().message(type);
		}
	}
	
	/**
	 * 用户删除商品（实则更改商品状态，将上架商品改为下架商品）
	 * @param g_id
	 * @return
	 */
	@PostMapping("/deleteGoodsByGid")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap deleteGoodsByGid(@RequestParam("g_id") String g_id) {
		int gId=Integer.parseInt(g_id);
		Integer deleteGoodsByGid = goodsService.deleteGoodsByGid(gId);
		if(deleteGoodsByGid>0) {
			return resultMap.success().message("删除成功");
		}else {
			return resultMap.fail().message("删除失败");
		}
	}
	
	@PostMapping("/getGoodsBySID")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap getGoodsBySID(@RequestParam("s_id") String s_id) {
		List<Goods> goodsBySID = goodsService.getGoodsBySID(Integer.valueOf(s_id));
		if (goodsBySID.size() > 0) {
			return resultMap.success().message(goodsBySID);
		} else {
			return resultMap.fail().message("该店铺暂时没有商品");
		}
	}

	@PostMapping("/updateGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap updateGoods(@RequestParam("goods") String g) {
		Goods goods = JSON.parseObject(g,Goods.class);
		Integer updateGoods = goodsService.updateGoods(goods);
		if (updateGoods > 0) {
			return resultMap.success().message("修改成功");
		} else {
			return resultMap.fail().message("修改失败");
		}
	}

	@PostMapping("/upGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap upGoods(@RequestParam("goods") String g) {
		Goods goods = JSON.parseObject(g,Goods.class);
		Integer upGoods = goodsService.upGoods(goods);
		if (upGoods > 0) {
			return resultMap.success().message("上架成功");
		} else {
			return resultMap.fail().message("上架失败，请稍后再试");
		}
	}

	@PostMapping("/downGoods")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap downGoods(@RequestParam("g_id") String g_id) {
		Integer downGoods = goodsService.downGoods(Integer.valueOf(g_id));
		if (downGoods > 0) {
			return resultMap.success().message("下架成功");
		} else {
			return resultMap.fail().message("下架失败");
		}
	}


}
