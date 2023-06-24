package com.shopping.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shopping.entity.Order;

import java.io.Serializable;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 14:11:07
 */
public interface OrderService extends IService<Order> {
    R selectOrderById(int id);
}

