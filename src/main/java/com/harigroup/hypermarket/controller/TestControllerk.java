package com.harigroup.hypermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.mapper.IUserMapper;
import com.harigroup.hypermarket.pojo.User;

@RestController
public class TestControllerk {
	
	@Autowired
	private IUserMapper usermapper;
	
	@GetMapping("/test")
	public String test() {
		return JSON.toJSONString(usermapper.selectList(null));
	}

}
