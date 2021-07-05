package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentHystrixService
 * @Description
 * @Date 2021/6/15 0015 16:11
 * @Created by 00320558
 */
@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-SERVICE",fallback =PaymentFallBackService.class )
public interface PaymentHystrixService {

    //http://localhost:8001/payment/hystrix/ok/10
    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    //http://localhost:8001/payment/hystrix/time_out/10
    @GetMapping("/payment/hystrix/time_out/{id}")
    public String time_out(@PathVariable("id") Integer id);

}

