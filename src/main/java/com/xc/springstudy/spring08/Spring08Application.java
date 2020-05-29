package com.xc.springstudy.spring08;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xc.springstudy.spring08.mapper")
public class Spring08Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring08Application.class, args);
    }

}
