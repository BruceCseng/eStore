package com.it.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.it.estore.dao"})
public class ProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class,args);
    }
}
