package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentFeignService
 * @Description
 * @Date 2021/6/11 0011 16:12
 * @Created by 00320558
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeOut")
    String timeOut();
}
