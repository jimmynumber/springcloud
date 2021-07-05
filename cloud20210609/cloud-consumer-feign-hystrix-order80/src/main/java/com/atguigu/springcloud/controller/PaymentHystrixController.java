package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname PaymentHystrixController
 * @Description
 * @Date 2021/6/15 0015 16:15
 * @Created by 00320558
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallbackHandler")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    //http://localhost/consumer/payment/hystrix/ok/10
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentHystrixService.ok(id);
    }

    //http://localhost/consumer/payment/hystrix/time_out/10
    @GetMapping("/consumer/payment/hystrix/time_out/{id}")
//    @HystrixCommand(fallbackMethod = "paymentinfo_timeOurHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    @HystrixCommand
    public String time_out(@PathVariable("id") Integer id){
        return paymentHystrixService.time_out(id);
    }

    public String paymentinfo_timeOurHandler(Integer id ){
        return "OrderHystrixMain80 系统繁忙，请稍后重试 paymentinfo_timeOurHandler ,id: "+id;
    }
    // 下面是全局异常fallback方法
    public String global_fallbackHandler(){
        return "我是全局异常兜底";
    }


}
