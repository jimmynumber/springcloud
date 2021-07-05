package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.*;

/**
 * @Classname GateWayConfig
 * @Description
 * @Date 2021/6/17 0017 10:01
 * @Created by 00320558
 */
@Configuration
public class GateWayConfig {
    // http://localhost:9527/guonei   =>   https://news.baidu.com/guonei
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route1_9527",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        routes.route("path_route2_9527",r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }



}
