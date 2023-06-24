package com.shopping.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shopping.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-02 14:11:06
 */
public interface OrderDao extends BaseMapper<Order> {
    List<Order> selectOrderById(@Param("id") int id);
}

