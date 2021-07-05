package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ConfigClientController
 * @Description
 * @Date 2021/6/21 0021 10:40
 * @Created by 00320558
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    //@Value("${aaa}")
    private String configInfo;
    // 若修改配置中心文件，需要执行以下 语句，获取最新数据
    // curl -X POST "http://localhost:3355/actuator/refresh"
    // http://localhost:3355/getConfigInfo
    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return this.configInfo;
    }


}
