package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentService
 * @Description
 * @Date 2021/6/25 0025 10:50
 * @Created by 00320558
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);
}
