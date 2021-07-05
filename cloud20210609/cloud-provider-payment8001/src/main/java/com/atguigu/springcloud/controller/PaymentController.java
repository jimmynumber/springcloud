/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: PaymentController
 * Author:   00320558
 * Date:     2021/3/31 0031 9:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 00320558
 * @create 2021/3/31 0031
 * @since 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    // http://localhost:8001/payment/get/1
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        log.info("/payment/get/{id}"+ LocalDate.now());
        Payment payment=paymentService.getPaymentById(id);
        if (payment != null ){
            return  new CommonResult<>(200,"查询成功,server.port:"+serverPort,payment);
        }else {
            return  new CommonResult<>(404,"查询失败",payment);
        }
    }

    //http://localhost:8001/payment/create?serial=jimmy
    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int count=paymentService.create(payment);
        if (count >0  ){
            return  new CommonResult<Integer>(200,"新增成功,server.port:"+serverPort,count);
        }else {
            return  new CommonResult<Integer>(404,"新增失败",null);
        }
    }

    //http://localhost:8001/payment/discovery
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("********element***:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    //http://localhost:8001/payment/lb
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return this.serverPort;
    }

    //http://localhost:8001/payment/timeOut
    @GetMapping("/payment/timeOut")
    public String timeOut(){
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.serverPort;
    }

    //http://localhost:8001/payment/zipkin
    @GetMapping("/payment/zipkin")
    public String getPaymentzipkin(){
        return "全链路 seluth zipkin 检测";
    }
}
