package com.harigroup.hypermarket.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.pojo.User;
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
	@GetMapping("/getAllUser/{pageIndex}/{pageSize}")
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
	public ResultMap getAllUser(@PathVariable String pageIndex,@PathVariable String pageSize) {
		PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		List<User> allUser = rootService.getAllUser();
		PageInfo<User> page = new PageInfo<>(allUser);
		return resultMap.success().message(allUser).addElement("total", page.getTotal());
	}

	/**
	 * 通过分类获取用户
	 * 
	 * @param calssify 分类
	 * @return
	 */
	@GetMapping("/getClassify/{calssify}")
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
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
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
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
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
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
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
	public ResultMap changeRole(@RequestParam("username") String username, @RequestParam("role") String role) {
		return resultMap.success().message(rootService.changeRole(username, role));
	}
	
	@GetMapping("/getAdminUserList/{now}/{size}")
	@RequiresRoles(logical = Logical.OR, value = {"admin","root"})
	public ResultMap getAdminUserList(@PathVariable String now,@PathVariable String size) {
		PageHelper.startPage(Integer.parseInt(now),Integer.parseInt(size));
		List<User> adminUserList = rootService.getAdminUserList();
		PageInfo<User> info = new PageInfo<>(adminUserList);
		return resultMap.success().message(adminUserList).addElement("total", info.getTotal());
	}

}
