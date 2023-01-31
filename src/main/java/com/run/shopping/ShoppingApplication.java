package com.run.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.run"})
@MapperScan("com.run.shopping.service.mapper")
public class ShoppingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);

    }

}
