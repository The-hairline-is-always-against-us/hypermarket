package com.harigroup.hypermarket.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件上传工具类（服务器上传，放心大胆传）
 * 	返回地址为图片地址全拼
 * 	如：
 * 		http://182.92.208.18:9000/project/20201009/8fab328f-b607-43b7-be19-c3e7e337d9e3
 * 
 * @author 13597
 *
 */
@Slf4j
public class MinioUtil {

	    private static MinioUtil minioUtil;

	    private MinioClient minioClient;

	    /**
	     * 获取MinIO工具类实例
	     *
	     * @return 返回实例
	     */
	    public static MinioUtil getInstance() {
	        if (null != minioUtil) {
	            return minioUtil;
	        }
	        synchronized (MinioUtil.class) {
	            if (null == minioUtil) {
	                minioUtil = new MinioUtil();
	            }
	        }
	        return minioUtil;
	    }

	    private MinioUtil() {
	        init();
	    }

	    private void init() {
	        String url = "http://182.92.208.18:9000/";
	        String username = "admin";
	        String password = "admin0704";
	        String region = "project";
	        try {
	            minioClient = new MinioClient(url, username, password);
	        } catch (Exception e) {
	            log.error("restClient.close occur error", e);
	        }

	    }

	    /**
	     *  上传文件——通过流的方式进行上传
	     *
	     * @param file 待操作文件
	     * @return 文件全地址
	     */
	    public String upLoadFile(MultipartFile file) {
	        String url = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        String ymd = sdf.format(new Date());
	        String objectName = ymd + "/" + UUID.randomUUID().toString();
	        try {
	            minioClient.putObject("project", objectName, file.getInputStream(), file.getContentType());
	            url = minioClient.getObjectUrl("project", objectName);
	        } catch (Exception e) {
	        	log.error("restClient.close occur error", e);
	        }
	        return url;
	    }
}
