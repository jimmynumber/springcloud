package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.*;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallBackService
 * @Description
 * @Date 2021/6/25 0025 - 10:54
 * @Created by 00320558
 */

@Component
public class PaymentFallBackService implements PaymentService{

    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(444,"global 服务降级统一返回",new Payment(id,null));
    }
}
