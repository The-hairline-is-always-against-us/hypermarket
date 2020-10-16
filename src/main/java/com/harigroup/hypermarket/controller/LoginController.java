package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.User;
import com.harigroup.hypermarket.service.IUserService;
import com.harigroup.hypermarket.utils.JWTUtil;
import com.harigroup.hypermarket.utils.RedisUtil;

/**
 * 登陆相关功能Controller | | | -- /login => 登陆方法 | -- 传递参数说明： username -> 用户名
 * password -> 用户密码
 * 
 * @author 13597
 *
 */
@RestController
public class LoginController {

	// 自动注入 默认为单例模式
	@Autowired
	private IUserService userService;
	@Autowired
	private ResultMap resultMap;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 登陆方法 —— 单点登录 对用户输入的用户名及密码进行认证 => 查询Redis中的身份凭证，如果不存在则插入凭证 => 如果存在则删除后再进行登录
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@PostMapping("/login")
	public ResultMap login(@RequestParam("username") String username, @RequestParam("password") String password) {

		User user = userService.login(username, password);

		if (user != null) {
			if (redisUtil.hasKey(user.getUsername())) {
				redisUtil.del(user.getUsername());
			}

			String newToken = JWTUtil.createToken(user.getUsername(), user.getU_id().toString(),
					user.getRole().getRole(), user.getRole().getPermission(), JSON.toJSONString(user.getRole()));

			redisUtil.set(user.getUsername(), newToken, 60 * 60 * 24);

			return resultMap.success().message(newToken);
		} else {
			return resultMap.fail().message("请输入正确的用户名或密码");
		}
	}
	
	/**
	 * 授权信息获取接口，用于前端后台的身份认证
	 * 
	 * @param token 凭证
	 * @return
	 */
	@PostMapping("/getInfPermiss")
	public ResultMap getInfPermiss(@RequestHeader("token") String token) {
		return null;
	}
}
