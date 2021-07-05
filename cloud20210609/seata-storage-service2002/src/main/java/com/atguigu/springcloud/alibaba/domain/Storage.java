package com.atguigu.springcloud.alibaba.domain;

import lombok.*;

/**
 * @Classname Storage
 * @Description
 * @Date 2021/6/28 0028 - 15:10
 * @Created by 00320558
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
