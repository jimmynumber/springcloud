package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname EurekaMain7002
 * @Description
 * @Date 2021/6/7 0007 10:22
 * @Created by 00320558
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    // http://localhost:7002/
    // http://eureka7002.com:7002/
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }

}