package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.mapper.IUserMapper;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.IUserService;

/**
 * 
 * @author 13597
 *
 */
@RestController
public class RegisterController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ResultMap resultMap;
	
	@PostMapping("/register")
	public ResultMap register(@RequestParam("user") String user) {
		return null;
	}
	
	@GetMapping("/validateu/{username}")
	public ResultMap validateUsername(@PathVariable("username") String username) {
		Integer validateUsername = userService.validateUsername(username);
		if (validateUsername > 0) {
			return resultMap.fail().message("已被使用");
		} else {
			return resultMap.success().message("可以使用");
		}
	}
	
	@GetMapping("/validatee/{email}")
	public ResultMap validateEmail(@PathVariable("email") String email) {
		return null;
	}
	
	@GetMapping("/validatep/{phone}")
	public ResultMap validatePhone(@PathVariable("phone") String phone) {
		return null;
	}
}
