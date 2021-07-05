package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MySelfRule
 * @Description
 * @Date 2021/6/8 0008 18:42
 * @Created by 00320558
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
//        return new RoundRobinRule(); //  默认为 轮询
        return new RandomRule(); // 定义为随机
//        return new RetryRule(); // 重试
    }
}
