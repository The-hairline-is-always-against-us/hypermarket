package com.harigroup.hypermarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harigroup.hypermarket.pojo.User;

/**
 * 用户相关的DAO层操作
 * 	--主要涉及到登陆以及注册中对于User表的操作
 * 	--其次涉及到管理员相关功能的一些操作
 * 
 * @author 13597
 *
 */
public interface IUserMapper extends BaseMapper<User> {
	User login(String username,String password);
}
