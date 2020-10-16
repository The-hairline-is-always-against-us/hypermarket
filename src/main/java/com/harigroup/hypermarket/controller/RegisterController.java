package com.harigroup.hypermarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.ResultMap;

/**
 * 
 * @author 13597
 *
 */
@RestController
public class RegisterController {
	
	@PostMapping("/register")
	public ResultMap register(@RequestParam("user") String user) {
		return null;
	}
	
	@GetMapping("/validate/{username}")
	public ResultMap validateUsername(@RequestParam("username") String username) {
		return null;
	}
	
	@GetMapping("/validate/{email}")
	public ResultMap validateEmail(@RequestParam("email") String email) {
		return null;
	}
	
	@GetMapping("/validate/{phone}")
	public ResultMap validatePhone(@RequestParam("phone") String phone) {
		return null;
	}
}
