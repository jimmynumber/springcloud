package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Classname FolwLimitController
 * @Description
 * @Date 2021/6/24 0024 10:39
 * @Created by 00320558
 */
@RestController
@Slf4j
public class FolwLimitController {

    // http://localhost:8401/testA/3 @PathVariable("id") Integer id
    // http://localhost:8401/testA
    @GetMapping(value = "/testA")
    public String testA() {
        return "FolwLimitController****testA*** now(): " + LocalDateTime.now();
    }

    // http://localhost:8401/testB/3
    // http://localhost:8401/testB
    @GetMapping(value = "/testB")
    public String testB() {
        return "FolwLimitController****testB*** now(): " + LocalDateTime.now();
    }


    // http://localhost:8401/testD
    @GetMapping(value = "/testD")
    public String testD() {
        log.info("testD 测试 RT :");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FolwLimitController****testD*** now(): " + LocalDateTime.now();
    }

    // http://localhost:8401/testHotKey
    // http://localhost:8401/testHotKey?p1=111&p2=2
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "****testHotKey*****now()" + LocalDateTime.now() + "\t ,p1:" + p1 + " ,p2:" + p2;
    }

    public String deal_testHotKey(String p1,String p2,BlockException exception) {
        return "****deal_testHotKey*****now()" + LocalDateTime.now() + "\t ,p1:" + p1 + " ,p2:" + p2+"\t\n BlockException:"+exception;
    }

}
