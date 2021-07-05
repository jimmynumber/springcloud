package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname StorageServiceImpl
 * @Description
 * @Date 2021/6/28 0028 - 15:40
 * @Created by 00320558
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productid,Integer count) {
        log.info("-------->开始扣减库存");
        storageDao.decrease(productid, count);
        log.info("-------->结束扣减库存");
    }
}
