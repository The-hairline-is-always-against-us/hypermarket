package com.harigroup.hypermarket.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.alibaba.fastjson.JSON;
import com.harigroup.hypermarket.mail.MailService;
import com.harigroup.hypermarket.pojo.Mail;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.User;
import com.harigroup.hypermarket.service.IUserService;
import com.harigroup.hypermarket.utils.Md5Encoding;
import com.harigroup.hypermarket.utils.RedisUtil;

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
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MailService mailService;
	
	@PostMapping("/register")
	public ResultMap register(@RequestParam("user") String user) {
		User parseObject = JSON.parseObject(user, User.class);
		parseObject.setPassword(Md5Encoding.md5FixSaltEncode(parseObject.getPassword()));
		
		int insert = userService.register(parseObject);
		
		if (insert > 0) {
            String userID = UUID.randomUUID().toString();
            redisUtil.set(userID, parseObject.getUsername());
            Context context = new Context();
            context.setVariable("userId", userID);
            Mail mail = mailService.prepareMail(context, parseObject.getEmail());
            mailService.sendActiveMail(mail);
            return resultMap.success().message("注册成功！请前往邮箱激活");
        }
        return resultMap.fail().code(40010).message("服务器内部错误");
	}
	
	@GetMapping("/validateu/{username}")
	public ResultMap validateUsername(@PathVariable String username) {
		Integer validateUsername = userService.validateUsername(username);
		if (validateUsername > 0) {
			return resultMap.fail().message("已被使用");
		} else {
			return resultMap.success().message("可以使用");
		}
	}
	
	@GetMapping("/validatee/{email}")
	public ResultMap validateEmail(@PathVariable String email) {
		Integer validateEmail = userService.validateEmail(email);
		return validateEmail == 0 ? resultMap.success().message("可以使用") : resultMap.fail().message("已被使用");
	}
	
	@GetMapping("/validatep/{phone}")
	public ResultMap validatePhone(@PathVariable String phone) {
		Integer validateEmail = userService.validatePhone(phone);
		return validateEmail == 0 ? resultMap.success().message("可以使用") : resultMap.fail().message("已被使用");
	}
	
	@GetMapping("/activation/{uuid}")
	public ResultMap activation(@PathVariable String uuid,HttpServletResponse response) throws IOException {
		
		if (!redisUtil.hasKey(uuid)) {
			return resultMap.fail().message("未知错误");
		}
		if (userService.jiHuo(redisUtil.get(uuid).toString()) > 0) {
			redisUtil.del(uuid);
			response.sendRedirect("http://localhost:8080");
			return resultMap.success().message("激活成功！");
		} else {
			return resultMap.fail().message("未知错误");
		}
	}
}
