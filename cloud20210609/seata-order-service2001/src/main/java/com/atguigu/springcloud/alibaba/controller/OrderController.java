package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.*;
import com.atguigu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description
 * @Date 2021/6/28 0028 - 11:34
 * @Created by 00320558
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    // http://localhost:2001/order/create?id=2&userid=1&productid=1&count=2&money=2&status=2
    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"创建订单成功");
    }

}