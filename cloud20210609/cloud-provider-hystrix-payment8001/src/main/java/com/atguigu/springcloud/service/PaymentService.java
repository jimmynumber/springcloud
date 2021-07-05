package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.*;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Classname PaymentService
 * @Description
 * @Date 2021/6/15 0015 14:02
 * @Created by 00320558
 */
@Service
public class PaymentService {
    public String ok(Integer id ){
        return "线程池: "+Thread.currentThread().getName()+" ok ,id: "+id;
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_timeOurHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String time_out(Integer id ){
        long time=5000L;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" time_out ,id: "+id+",耗时："+time+" 秒";
    }

    public String paymentinfo_timeOurHandler(Integer id ){
        return "线程池: "+Thread.currentThread().getName()+" 系统繁忙，请稍后重试 paymentinfo_timeOurHandler ,id: "+id;
    }

    // 服务熔断机制
    @HystrixCommand(fallbackMethod = "paymentCircuiBreaker_fallBack",commandProperties = {
            @HystrixProperty(name= HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value="true"), // 是否开启断路器
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value="10"), //请求次数
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value="10000"), // 时间范围
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value="60") //失败率达到多少跳闸
    })
    public String paymentCircuiBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public String paymentCircuiBreaker_fallBack(Integer id){
        return "请稍后重试";
    }
}
