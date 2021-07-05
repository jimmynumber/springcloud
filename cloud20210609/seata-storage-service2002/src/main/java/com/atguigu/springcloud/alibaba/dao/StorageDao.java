package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.*;

/**
 * @Classname StorageDao
 * @Description
 * @Date 2021/6/28 0028 - 15:14
 * @Created by 00320558
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
