package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author solang
 * @date 2021-03-30 20:01
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
