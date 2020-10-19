package com.harigroup.hypermarket.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * user表对应实体类
 * 
 * @author 13597
 *
 */
@Data
@TableName("tb_user")
public class User {
	//用户表主键
	private Integer u_id;
	//用户名
	private String username;
	//用户密码
	private String password;
	//用户邮箱
	private String email;
	//用户手机号
	private String phone;
	//用户权限ID
	private Integer ur_id;
	//用户账户激活状态
	private Integer ban;
	//用户封禁/禁用状态
	private Integer del_flag;
	//备用字段内部封装，用于统一获取权限具体内容
	@TableField(exist = false)
	private Role role;
	private String confirmPass;
}
