package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2021/6/22 0022 19:28
 * @Created by 00320558
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    // http://localhost:9001/payment/nacos/33
    @GetMapping(value = "/payment/nacos/{id}")
    public String getNacos(@PathVariable("id") Integer id){
        return "nacos registry , serverPort :"+this.serverPort+"\t"+"id :"+ id;
    }
}
