package com.harigroup.hypermarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.mapper.IUserMapper;
import com.harigroup.hypermarket.pojo.User;

@SpringBootTest
class HypermarketApplicationTests {

	@Autowired
	IUserMapper userMapper;
	
	@Test
	void contextLoads() {
		User login = userMapper.login("root", "root");
		
		String json = JSON.toJSONString(login);
		
		User u = JSON.parseObject(json,User.class);
		
		
	}
	
}
