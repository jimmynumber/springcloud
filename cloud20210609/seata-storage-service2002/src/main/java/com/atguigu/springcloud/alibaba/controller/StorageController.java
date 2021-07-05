package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname StorageController
 * @Description
 * @Date 2021/6/28 0028 - 15:48
 * @Created by 00320558
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    // http://localhost:2002/storage/decrease?productId=1&count=2
    @RequestMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam(value="productId",required =false) Long productId,@RequestParam(value="count",required =false) Integer count) {
        log.info("********StorageController******************");

        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
