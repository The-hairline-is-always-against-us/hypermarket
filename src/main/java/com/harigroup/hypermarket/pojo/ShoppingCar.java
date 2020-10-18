package com.harigroup.hypermarket.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ShoppingCar implements Serializable {
	private Integer g_id;
	private Integer c_id;
	private String g_picture;
	private String g_name;
	private Integer c_number;
	private Integer g_price;
	private Integer o_number;
	private Date order_time;
	private Integer o_id;
}
