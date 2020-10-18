package com.harigroup.hypermarket.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 商铺表(tb_store)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_store")
public class Store {
	//店铺表id
	private Integer s_id;
	//店铺名称
	private String s_name;
	//与用户表关联
	private Integer u_id;
	//批准时间
	private Date create_time;
	//申请时间
	private Date request_time;
	//店铺简介
	private String s_intro;
	//店铺状态（0：店铺关闭，1：店铺正常）
	private Integer s_status;
	
	@TableField(exist = false)
	private Integer sale_count;
}
