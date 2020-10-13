package com.harigroup.hypermarket.service;

import com.harigroup.hypermarket.pojo.User;

/**
 * 用户相关的Service层操作
 * 	--主要涉及到登陆以及注册中对于User表的操作
 * 	--其次涉及到管理员相关功能的一些操作
 * 
 * 预留为准备多线程、切面编程以及设计模式
 * 
 * @author 13597
 *
 */
public interface IUserService {
	User login(String username, String password);
}
