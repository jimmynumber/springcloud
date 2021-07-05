package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.*;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname CircleBreakerController
 * @Description
 * @Date 2021/6/25 0025 - 9:13
 * @Created by 00320558
 */
@RestController
@Slf4j
public class CircleBreakerController {
    private static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    // http://localhost:84/consumer/fallback/3
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerfallback") // 负责异常处理
//    @SentinelResource(value = "fallback",fallback = "" ,fallbackClass = "") // 负责异常处理
    @SentinelResource(value = "fallback",
            fallback = "handlerfallback",
            blockHandler="blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class} //多个用，分隔 忽略某一个异常信息
    ) // 负责配置违规
    public CommonResult fallback(@PathVariable("id")Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id,CommonResult.class,id);
        if (id ==7){
            throw new IllegalArgumentException("非法参数");
        }else if(result== null || result.getData() == null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public CommonResult handlerfallback(@PathVariable Long id,Throwable e){
        return new CommonResult(444,"兜底异常："+e.getMessage(),new Payment(id,null));
    }
    public CommonResult blockHandler(@PathVariable Long id,BlockException e){
        return new CommonResult(444,"blockHandler-sentinel 限流异常："+e.getMessage(),new Payment(id,null));
    }

    //***********************
    @Resource
    private PaymentService paymentService;

    // http://localhost:84/consumer/payment/3
    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentService.getPayment(id);
    }

}
