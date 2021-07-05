package com.atguigu.springcloud.controller;

import cn.hutool.core.lang.UUID;
import com.atguigu.springcloud.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Classname PaymentController
 * @Description
 * @Date 2021/6/24 0024 - 18:42
 * @Created by 00320558
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Long, Payment> hashMap = new HashMap();
    static{
        hashMap.put(1L,new Payment(1L,UUID.randomUUID()+""));
        hashMap.put(2L,new Payment(2L,UUID.randomUUID()+""));
        hashMap.put(3L,new Payment(3L,UUID.randomUUID()+""));
    }

    // http:localhost:9004/payment/1
    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        return new CommonResult(200,"server.port:"+this.serverPort,hashMap.get(id));
    }

}
