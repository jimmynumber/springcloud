/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: PaymentServiceImpl
 * Author:   00320558
 * Date:     2021/3/30 0030 20:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.atguigu.springcloud.service.impl;/**
 * @author solang
 * @date 2021-03-30 20:02  
 */

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 00320558
 * @create 2021/3/30 0030
 * @since 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
