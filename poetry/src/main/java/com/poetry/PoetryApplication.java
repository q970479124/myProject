package com.poetry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.poetry.infterface")
public class PoetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoetryApplication.class, args);
	}

}
