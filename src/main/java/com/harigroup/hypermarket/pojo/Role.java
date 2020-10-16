package com.harigroup.hypermarket.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * u_role表的实体对应类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_u_role")
public class Role {
	//权限表主键
	private Integer ur_id;
	//用户权限
	private String role;
	//权限细分
	private String permission;
}
