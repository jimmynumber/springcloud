package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystrixDashBoardMain9001
 * @Description
 * @Date 2021/6/16 0016 15:43
 * @Created by 00320558
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {

    // http://localhost:9001/hystrix

    // http://localhost:8001/hystrix.stream
    // Delay 2000
    // Title 随便娶
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardMain9001.class,args);
    }
}
