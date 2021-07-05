/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Payment
 * Author:   00320558
 * Date:     2021/3/30 0030 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.atguigu.springcloud.entities;/**
 * @author solang
 * @date 2021-03-30 19:21  
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 00320558
 * @create 2021/3/30 0030
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
