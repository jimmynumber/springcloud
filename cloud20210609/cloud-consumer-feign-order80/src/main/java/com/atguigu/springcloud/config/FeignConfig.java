package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.*;

/**
 * @Classname FeignConfig
 * @Description
 * @Date 2021/6/15 0015 12:08
 * @Created by 00320558
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
