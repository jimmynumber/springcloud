package com.atguigu.springcloud.alibaba.domain;

import lombok.*;

/**
 * @Classname CommonResult
 * @Description
 * @Date 2021/6/28 0028 - 15:07
 * @Created by 00320558
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }
}
