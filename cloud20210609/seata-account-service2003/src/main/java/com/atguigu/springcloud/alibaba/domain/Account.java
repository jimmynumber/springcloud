package com.atguigu.springcloud.alibaba.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @Classname Account
 * @Description
 * @Date 2021/6/28 0028 - 18:06
 * @Created by 00320558
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private long id;
    private long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
