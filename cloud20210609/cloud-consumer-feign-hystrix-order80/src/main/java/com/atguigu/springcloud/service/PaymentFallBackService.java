package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallBackService
 * @Description
 * @Date 2021/6/15 0015 18:34
 * @Created by 00320558
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String ok(Integer id) {
        return "*****PaymentFallBackService***ok**id: "+id;
    }

    @Override
    public String time_out(Integer id) {
        return "*****PaymentFallBackService***time_out**id: "+id;
    }
}
