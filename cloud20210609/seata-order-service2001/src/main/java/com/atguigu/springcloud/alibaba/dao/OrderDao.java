package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.*;

/**
 * @Classname OrderDao
 * @Description
 * @Date 2021/6/25 0025 - 16:55
 * @Created by 00320558
 */
@Mapper
public interface OrderDao {
    void create(Order order);

    void update(@Param("userid") long userid,@Param("status") Integer status);
}
