package com.jw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jw.mapper")
public class JwApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwApplication.class, args);
    }

}
