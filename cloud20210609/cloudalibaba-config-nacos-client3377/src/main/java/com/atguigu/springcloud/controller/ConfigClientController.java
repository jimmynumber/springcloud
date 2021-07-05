package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ConfigClientController
 * @Description
 * @Date 2021/6/23 0023 11:31
 * @Created by 00320558
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

   // 1 2
   // 2 PPPP
   // 3


    // http://localhost:3377/config/info
    @GetMapping(value = "/config/info")
    public String getConfigInfo() {
        System.out.println("configInfo:******* " + configInfo);
        return this.configInfo;
    }
}
