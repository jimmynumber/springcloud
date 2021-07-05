package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname EurekaMain7001
 * @Description
 * @Date 2021/6/7 0007 9:36
 * @Created by 00320558
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    // http://localhost:7001/
    // http://eureka7001.com:7001/
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }

}
