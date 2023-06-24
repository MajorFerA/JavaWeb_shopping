package com.shopping.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shopping.entity.Shopping;

/**
 * (Shoping)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 14:11:08
 */
public interface ShoppingService extends IService<Shopping> {
    R selectShoppingById(int id);
}

