package com.harigroup.hypermarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harigroup.hypermarket.mapper.IRootAdminMapper;
import com.harigroup.hypermarket.pojo.User;
import com.harigroup.hypermarket.service.IRootAdminService;

/**
 * Service层实现类
 * 
 * @author 13597
 *
 */
@Service
public class RootAdminServiceImpl implements IRootAdminService {
	
	@Autowired
	private IRootAdminMapper rootMapper;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return rootMapper.getAllUser();
	}

	@Override
	public List<User> getClassifyUser(String calssify) {
		// TODO Auto-generated method stub
		return rootMapper.getClassifyUser(calssify);
	}

	@Override
	public Integer deleteUser(String username) {
		// TODO Auto-generated method stub
		return rootMapper.deleteUser(username);
	}

	@Override
	public Integer changeRole(String username, String role) {
		// TODO Auto-generated method stub
		return rootMapper.changeRole(username, role);
	}

	@Override
	public Integer unDeleteUser(String username) {
		// TODO Auto-generated method stub
		return rootMapper.unDeleteUser(username);
	}

}
