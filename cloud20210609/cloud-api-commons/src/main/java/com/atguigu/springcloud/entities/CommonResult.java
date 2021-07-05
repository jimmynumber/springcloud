/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: CommonResult
 * Author:   00320558
 * Date:     2021/3/30 0030 19:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.atguigu.springcloud.entities;/**
 * @author solang
 * @date 2021-03-30 19:25  
 */
import lombok.Data;

@Data
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
