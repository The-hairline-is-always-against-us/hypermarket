package com.harigroup.hypermarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IUserMapper;
import com.harigroup.hypermarket.pojo.User;
import com.harigroup.hypermarket.service.IUserService;

/**
 * 实现类默认调用返回
 * 
 * 特殊方法进行特殊处理
 * 
 * @author 13597
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}

}
