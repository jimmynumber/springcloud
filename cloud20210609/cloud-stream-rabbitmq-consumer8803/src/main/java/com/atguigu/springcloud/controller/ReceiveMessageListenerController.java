package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.*;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname ReceiveMessageListenerController
 * @Description
 * @Date 2021/6/22 0022 16:04
 * @Created by 00320558
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("consumer 2 ----->接受到的消息："+message.getPayload()+"\t"+" serverPort"+this.serverPort);
    }
}
