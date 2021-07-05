package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.controller.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Classname RatelimitController
 * @Description
 * @Date 2021/6/24 0024 17:01
 * @Created by 00320558
 */
@RestController
@Slf4j
public class RateLimitController {

    // http:localhost:8401/byResource
    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按照资源名称限流测试,OK",new Payment(1L,LocalDateTime.now()+""));
    }

    public CommonResult handlerException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    // http:localhost:8401/byURL
    @GetMapping(value = "/byURL")
    @SentinelResource(value = "byURL")
    public CommonResult byURL(){
        return new CommonResult(200,"按照URL限流测试,OK",new Payment(1L,LocalDateTime.now()+""));
    }

    // http:localhost:8401/customerBlockHandler
    @GetMapping(value = "/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "blockhandler")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按照客户自定义 测试,OK",new Payment(1L,LocalDateTime.now()+""));
    }
}
