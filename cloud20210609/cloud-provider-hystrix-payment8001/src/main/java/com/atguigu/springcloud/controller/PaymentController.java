package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2021/6/15 0015 14:08
 * @Created by 00320558
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //http://localhost:8001/payment/hystrix/ok/10
    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        log.info("*****ok******id:"+id);
        return paymentService.ok(id);
    }

    //http://localhost:8001/payment/hystrix/time_out/10
    @GetMapping("/payment/hystrix/time_out/{id}")
    public String time_out(@PathVariable("id") Integer id){
        log.info("*****time_out******id:"+id);
        return paymentService.time_out(id);
    }

    //http://localhost:8001/payment/circuit/10
    // 服务熔断机制
    @GetMapping("/payment/circuit/{id}")
    public String  paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuiBreaker(id);
        log.info("***result:***" +result);
        return result;
    }
}
