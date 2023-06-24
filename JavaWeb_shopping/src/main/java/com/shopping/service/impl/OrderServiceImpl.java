package com.shopping.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopping.dao.OrderDao;
import com.shopping.entity.Order;
import com.shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 14:11:07
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Override
    public R selectOrderById(int id) {
        System.out.println(id);
        List<Order> orders = baseMapper.selectOrderById((Integer) id);
        return R.ok(orders);
    }
}

