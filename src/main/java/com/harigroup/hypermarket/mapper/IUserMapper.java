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
	
	/**
	 * 登陆DAO接口
	 * @param username 用户名
	 * @param password 密码
	 * @return User封装实体类
	 */
	User login(String username,String password);
	
	/**
	 * 登录后前端身份认证DAO接口
	 * @param u_id
	 * @return User封装实体类
	 */
	User getInfForPermiss(String u_id);
	
	/**
	 * 注册功能DAO接口
	 * @param user User实体类
	 * @return 受影响的行数
	 */
	Integer register(User user);
	
	/**
	 * 表单验证（用户名验证）后端查询DAO接口
	 * @param username 需要校验的用户名
	 * @return 数据库中存在的数量
	 */
	Integer validateUsername(String username);
	
	/**
	 * 表单验证（邮箱认证）后端查询DAO接口
	 * @param email 需要验证的邮箱
	 * @return 数据库中存在的数量
	 */
	Integer validateEmail(String email);
	
	/**
	 * 表单验证（电话认证）后端查询DAO接口
	 * @param phone 需要验证的电话
	 * @return 数据库中存在的数量
	 */
	Integer validatePhone(String phone);
	
	Integer jiHuo(String u_id);
	
}
