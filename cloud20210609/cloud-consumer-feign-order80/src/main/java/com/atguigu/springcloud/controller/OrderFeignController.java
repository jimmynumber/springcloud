package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.*;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname OrderFeignController
 * @Description
 * @Date 2021/6/11 0011 16:23
 * @Created by 00320558
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    //http://localhost/consumer/payment/get/1
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }

    //http://localhost/consumer/payment/feign/timeOut
    @GetMapping("/consumer/payment/feign/timeOut")
    public String timeOut(){
        return paymentFeignService.timeOut();
    }
}
