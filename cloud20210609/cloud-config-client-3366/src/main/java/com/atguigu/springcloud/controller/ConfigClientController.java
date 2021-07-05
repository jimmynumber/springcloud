package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ConfigClientController
 * @Description
 * @Date 2021/6/22 0022 9:57
 * @Created by 00320558
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    // http://localhost:3366/getConfigInfo
    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){

        return "server.port : "+this.serverPort+"\n\t"+"config.info : "+this.configInfo;
    }
}
