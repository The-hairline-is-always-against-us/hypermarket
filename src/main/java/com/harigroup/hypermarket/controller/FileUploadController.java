package com.harigroup.hypermarket.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harigroup.hypermarket.pojo.ResultMap;
import com.harigroup.hypermarket.utils.MinioUtil;

@RestController
public class FileUploadController {
	
	@Autowired
	ResultMap resultMap;
	
	@PostMapping("/loadFile")
	@RequiresRoles(logical = Logical.OR, value = {"user","admin","solder","root"})
	public ResultMap loadFile(@RequestParam("file") MultipartFile file) {

		MinioUtil instance = MinioUtil.getInstance();
		String upLoadFile = instance.upLoadFile(file);
		
		return resultMap.success().message(upLoadFile);
	}

}
