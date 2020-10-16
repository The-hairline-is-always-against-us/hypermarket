package com.harigroup.hypermarket.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 收藏表(tb_collect)对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_collect")
public class Collect {
	//收藏表主键ID
	private Integer col_id;
	//与用户表主键做关联
	private Integer u_id;
	//与商品表主键做关联
	private Integer g_id;
}
