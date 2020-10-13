package com.harigroup.hypermarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.harigroup.hypermarket.mapper")
public class HypermarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypermarketApplication.class, args);
	}

}
