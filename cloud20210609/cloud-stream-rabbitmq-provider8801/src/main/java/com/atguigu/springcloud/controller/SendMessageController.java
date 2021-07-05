package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname SendMessageController
 * @Description
 * @Date 2021/6/22 0022 14:38
 * @Created by 00320558
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    // http://localhost/8801/sendMessage
    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }


}
