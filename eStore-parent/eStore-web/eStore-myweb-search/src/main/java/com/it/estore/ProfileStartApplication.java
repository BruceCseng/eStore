package com.it.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/15 下午10:34
 * @Description: com.it.estore
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.it.estore.profile.feign")
public class ProfileStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileStartApplication.class,args);
    }

    @Bean("restTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
