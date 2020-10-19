package com.harigroup.hypermarket.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Mail implements Serializable {
    
	private static final long serialVersionUID = -3821263611826009237L;
	
	/**
     * 邮件发送方
     */
    private String from;
    /**
     * 邮件接收方
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String mailContent;
}
