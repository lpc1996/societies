package com.lpc.system1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lpc.system1.mapper")
@SpringBootApplication
public class System1Application {

    public static void main(String[] args) {
        SpringApplication.run(System1Application.class, args);
    }

}
