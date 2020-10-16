package com.harigroup.hypermarket.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 商品类别表(tb_type)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_type")
public class Type {
	//商品类别id
	private Integer t_id;
	//商品类别名称
	private String t_name;
	//类别状态（1：正常，2：废弃）
	private Integer t_status;
}
