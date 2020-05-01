package com.chuan.accounts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 丶武僧
 * 程序主类
 */

@SpringBootApplication
@MapperScan("com.chuan.accounts.dao")
public class AccountsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApiApplication.class, args);
	}

}
