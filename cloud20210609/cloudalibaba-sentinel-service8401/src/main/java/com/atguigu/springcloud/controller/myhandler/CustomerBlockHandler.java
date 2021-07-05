package com.atguigu.springcloud.controller.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @Classname CustomerBlockHandler
 * @Description
 * @Date 2021/6/24 0024 17:34
 * @Created by 00320558
 */

public class CustomerBlockHandler {

    public static CommonResult blockhandler(BlockException exception){
        return new CommonResult(444,"客户自定义 global "+exception.getClass().getCanonicalName());
    }

    public static CommonResult blockhandler2(BlockException exception){
        return new CommonResult(444,"客户自定义2 global "+exception.getClass().getCanonicalName());
    }
}
