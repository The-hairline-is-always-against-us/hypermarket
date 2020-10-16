package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 订单表(tb_orderform)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_orderform")
public class Orderform {
	//订单号
	private Integer o_id;
	//用户ID
	private Integer u_id;
	//商品ID
	private Integer g_id;
	//下单时间
	private Date order_time;
	//购买商品数量
	private Integer o_number;
	//订单价格
	private Double price;
	//支付状态（0：未支付，1：已支付）
	private Integer pay_status;
}
