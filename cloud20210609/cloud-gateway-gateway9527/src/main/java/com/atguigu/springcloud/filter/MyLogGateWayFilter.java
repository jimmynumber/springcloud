package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Classname MyLogGateWayFilter
 * @Description
 * @Date 2021/6/17 0017 10:41
 * @Created by 00320558
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    // 之前地址 http://localhost:9527/payment/get/1  http://localhost:9527/payment/lb
    // 现在地址 http://localhost:9527/payment/get/1?uname=55  http://localhost:9527/payment/lb?uname=55
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        log.info("**********MyLogGateWayFilter**************"+ LocalDateTime.now());
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        if(queryParams.getFirst("uname") == null ){
            log.info("*****登录不成功****");
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //return response.setComplete();
        }
        return chain.filter(exchange);
    }

    // 数字 越小 优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
