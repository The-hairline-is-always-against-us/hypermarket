package com.harigroup.hypermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.service.IRootAdminService;

/**
 * 根用户操作类
 * 
 * @author 13597
 *
 */
@RestController
@RequestMapping("/root")
public class RootAdminController {

	@Autowired
	private ResultMap resultMap;
	@Autowired
	private IRootAdminService rootService;

	/**
	 * 获取所有用户方法
	 * 
	 * @return
	 */
	@GetMapping("/getAllUser")
	public ResultMap getAllUser() {
		return resultMap.success().message(rootService.getAllUser());
	}

	/**
	 * 通过分类获取用户
	 * 
	 * @param calssify 分类
	 * @return
	 */
	@GetMapping("/getClassify/{calssify}")
	public ResultMap getClassifyUser(@PathVariable String calssify) {
		return resultMap.success().message(rootService.getClassifyUser(calssify));
	}

	/**
	 * 删除用户（表面删除，实则修改删除标志位)
	 * 
	 * @param username 被设置用户的用户名
	 * @return
	 */
	@GetMapping("/deleteUser/{username}")
	public ResultMap deleteUser(@PathVariable String username) {
		return resultMap.success().message(rootService.deleteUser(username));
	}
	
	/**
	 * 解封用户
	 * 
	 * @param username 被解封的用户名
	 * @return
	 */
	@GetMapping("/unDeleteUser/{username}")
	public ResultMap unDeleteUser(@PathVariable String username) {
		return resultMap.success().message(rootService.unDeleteUser(username));
	}

	/**
	 * 修改用户权限，比如成为商家或者对管理员进行权限设置
	 * 
	 * @param username 被设置用户的用户名
	 * @return
	 */
	@PostMapping("/changeRole")
	public ResultMap changeRole(@RequestParam("username") String username, @RequestParam("role") String role) {
		return resultMap.success().message(rootService.changeRole(username, role));
	}
	
	@GetMapping("/getAdminUserList")
	public ResultMap getAdminUserList() {
		return resultMap.success().message(rootService.getAdminUserList());
	}

}
