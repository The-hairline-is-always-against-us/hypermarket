package com.harigroup.hypermarket.pojo;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * 前段返回值通用封装类
 * 	Map键值对格式进行数据的传递
 * 
 * @author 13597
 *
 */
@Component
public class ResultMap extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 228816996347357364L;

	/**
	 * 代表请求成功
	 * @return 链式调用
	 */
	public ResultMap success() {
		this.put("state", "success");
		this.code(200);
		return this;
	}
	
	/**
	 * 代表请求失败
	 * @return 链式调用
	 */
	public ResultMap fail() {
		this.put("state", "fail");
		this.code(500);
		return this;
	}
	
	/**
	 * 请求返回码（此处为自动以返回码，用于进行返回判断）
	 * @return 链式调用
	 */
	public ResultMap code(int code) {
		this.put("code", code);
		return this;
	}
	
	/**
	 * 返回请求成功后的返回携带信息
	 * @return 链式调用
	 */
	public ResultMap message(Object message) {
		this.put("message", message);
		return this;
	}
	
	/**
	 * 自定义返回键值对
	 * @return 链式调用
	 */
	public ResultMap addElement(String key,Object element) {
		this.put(key, element);
		return this;
	}
}
