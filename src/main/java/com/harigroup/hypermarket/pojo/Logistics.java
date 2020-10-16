package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 物流表(tb_logistics)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_logistics")
public class Logistics {
	//物流信息表的主键ID
	private Integer i_id;
	//与订单表主键做关联
	private Integer o_id;
	//与商品表主键做关联
	private Integer g_id;
	//与商铺信息表做关联
	private Integer s_id;
	//与卖家信息表关联
	private Integer u_id;
	//发货时间
	private Date send_time;
	//收货时间
	private Date recive_time;
	//订单发货状态（0：未发货，1：运输中，2：发货完成）
	private Integer i_status;
}
