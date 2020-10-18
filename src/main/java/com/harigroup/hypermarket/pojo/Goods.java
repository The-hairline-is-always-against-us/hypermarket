package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 商品表(tb_goods)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_goods")
public class Goods {
	//商品表主键ID
	private Integer g_id;
	//与列别表主键关联
	private Integer t_id;
	//与店铺表主键关联
	private Integer s_id;
	//商品名称
	private String g_name;
	//商品介绍
	private String g_intro;
	//商品价格
	private Double g_price;
	//商品库存
	private Integer g_total;
	//商品上架时间
	private Date uptime;
	//商品下架时间
	private Date downtime;
	//判断商品上下架状态（0：下架，1：商家）默认为0
	private Integer g_status;
	//商品图片
	private String g_picture;
	@TableField(exist = false)
	private String t_name;
	private String s_name;
}
