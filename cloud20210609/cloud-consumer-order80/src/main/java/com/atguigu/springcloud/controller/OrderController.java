package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description
 * @Date 2021/6/4 0004 16:45
 * @Created by 00320558
 */

@RestController
@Slf4j
public class OrderController {

    //private static final String url="http://localhost:8001";
    private static final String url="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //http://localhost:8001/payment/get/1
    //http://localhost:80/consumer/payment/get/1
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return  restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }

    //http://localhost:8001/payment/create?serial=jimmy
    //http://localhost:80/consumer/payment/create?serial=jimmy
    @GetMapping("/consumer/payment/create")
    public CommonResult<Integer> create(Payment payment){
        return  restTemplate.postForObject(url+"payment/create/",payment,CommonResult.class);
    }

    //http://localhost:80/consumer/payment/zipkin
    @GetMapping("/consumer/payment/zipkin")
    public String getPaymentzipkin(){
        return  restTemplate.getForObject(url+"/payment/zipkin",String.class);
    }
}
