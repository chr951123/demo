package com.tsune.vhr02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tsune.vhr02.dao")
public class Vhr02Application {

    public static void main(String[] args) {
        SpringApplication.run(Vhr02Application.class, args);
    }

}
