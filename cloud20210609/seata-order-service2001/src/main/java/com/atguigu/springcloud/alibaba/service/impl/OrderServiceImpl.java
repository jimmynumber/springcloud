package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.*;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Description
 * @Date 2021/6/25 0025 - 17:22
 * @Created by 00320558
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "my-create-order",rollbackFor = Exception.class) // 全局异常回滚机制
    @Override
    public void create(Order order) {

        log.info("开始新建订单");
        orderDao.create(order);

        log.info("开始扣库存 Count");
        storageService.decrease(order.getProductid(),order.getCount());

        log.info("开始扣账户 Money");
        accountService.decrease(order.getUserid(),order.getMoney());

        // 开始修改订单状态，从0到1
        log.info("修改订单状态");
        orderDao.update(order.getUserid(),0);


    }
}
