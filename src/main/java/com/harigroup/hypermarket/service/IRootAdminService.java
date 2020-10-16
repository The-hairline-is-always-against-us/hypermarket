package com.harigroup.hypermarket.service;

import java.util.List;

import com.harigroup.hypermarket.pojo.User;

/**
 * 根用户身份管理Service层接口
 * 
 * @author 13597
 *
 */
public interface IRootAdminService {
	/**
	 * 获取所有用户方法
	 * 
	 * @return 用户List集合
	 */
	List<User> getAllUser();

	/**
	 * 通过分类获取用户
	 * 
	 * @param calssify 分类
	 * @return 用户List集合
	 */
	List<User> getClassifyUser(String calssify);

	/**
	 * 删除用户（表面删除，实则修改删除标志位)
	 * 
	 * @param username 被设置用户的用户名
	 * @return 受影响的行数
	 */
	Integer deleteUser(String username);

	/**
	 * 修改用户权限，比如成为商家或者对管理员进行权限设置
	 * 
	 * @param username 被设置用户的用户名
	 * @return 受影响的行数
	 */
	Integer changeRole(String username, String role);
	
	/**
	 * 解封用户
	 * 
	 * @param username 被解封用户的用户名
	 * @return 受影响的行数
	 */
	Integer unDeleteUser(String username);
}
