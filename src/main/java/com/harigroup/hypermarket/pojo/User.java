package com.harigroup.hypermarket.pojo;

import lombok.Data;

@Data
public class User {
	private Integer u_id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Integer u_role;
	private Integer ban;
	private Integer del_flag;
}
