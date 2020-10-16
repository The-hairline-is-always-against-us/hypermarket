package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 用户收货地址表(tb_reciver)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_reciver")
public class Receiver {
	//收货地址表主键
	private Integer r_id;
	//用户表ID
	private Integer u_id;
	//订单ID
	private Integer o_id;
	//收货人姓名
	private String r_name;
	//收货人电话
	private String r_phone;
	//省份
	private String r_province;
	//城市
	private String r_city;
	//区县
	private String r_district;
	//详细地址
	private String r_address;
	//创建时间
	private Date createtime;
}
