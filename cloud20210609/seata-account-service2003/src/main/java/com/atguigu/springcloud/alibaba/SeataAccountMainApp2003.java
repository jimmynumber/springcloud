package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataAccountMainApp2003
 * @Description
 * @Date 2021/6/28 0028 - 17:39
 * @Created by 00320558
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class,args);
    }
}