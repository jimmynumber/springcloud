package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataStorageMainApp2002
 * @Description
 * @Date 2021/6/28 0028 - 15:08
 * @Created by 00320558
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class,args);
    }
}
