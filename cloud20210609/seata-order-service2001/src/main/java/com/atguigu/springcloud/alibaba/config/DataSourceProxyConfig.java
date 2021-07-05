//package com.atguigu.springcloud.alibaba.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.*;
//
//import javax.sql.DataSource;
//
//
///**
// * @Classname DataSourceProxyConfig
// * @Description
// * @Date 2021/7/2 0002 - 10:54
// * @Created by 00320558
// */
//@Configuration
//public class DataSourceProxyConfig {
//
//    @Value("${mybatis.mapper-locations}")
//    private String mapperLocations;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//
//
//    public DataSourceProxy dataSourceProxy(DataSource dataSource){
//        return new DataSourceProxy(dataSource);
//    }
//
//}
