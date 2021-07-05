package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @Classname AccountCountroller
 * @Description
 * @Date 2021/6/28 0028 - 17:56
 * @Created by 00320558
 */
@RestController
@Slf4j
public class AccountCountroller {

    @Autowired
    private AccountService accountService;

    // http://localhost:2003/account/decrease?userId=1&money=2
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam(value = "userId", required = false) Long userId,@RequestParam(value = "money", required = false) BigDecimal money) {
        accountService.decrease(userId,money);
        return new CommonResult<>(200,"扣减账户余额成功");
    }
}
