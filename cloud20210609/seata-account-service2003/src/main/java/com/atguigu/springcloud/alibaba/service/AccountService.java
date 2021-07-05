package com.atguigu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description
 * @Date 2021/6/28 0028 - 17:51
 * @Created by 00320558
 */

public interface AccountService {
    void decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
