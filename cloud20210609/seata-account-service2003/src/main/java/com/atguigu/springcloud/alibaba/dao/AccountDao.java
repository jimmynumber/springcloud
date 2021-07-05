package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

/**
 * @Classname AccountDao
 * @Description
 * @Date 2021/6/28 0028 - 17:45
 * @Created by 00320558
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
