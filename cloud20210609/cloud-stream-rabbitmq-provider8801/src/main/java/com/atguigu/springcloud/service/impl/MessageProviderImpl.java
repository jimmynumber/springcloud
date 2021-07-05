package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname MessageProviderImpl
 * @Description
 * @Date 2021/6/22 0022 14:15
 * @Created by 00320558
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replaceAll("_","");
        boolean send = output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*********serial***************: "+serial+" ,boolean:"+send);
        return serial;
    }
}
