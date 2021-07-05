package com.atguigu.springcloud.alibaba.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Description
 * @Date 2021/6/25 0025 - 16:52
 * @Created by 00320558
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userid;
    private Long productid;
    private Integer count;
    private BigDecimal money;
    private Integer status; // 0:创建中，1：已完结
}
