package com.shopping.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopping.dao.ShoppingDao;
import com.shopping.entity.Shopping;
import com.shopping.service.ShoppingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Shoping)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 14:11:08
 */
@Service("shopingService")
public class ShoppingServiceImpl extends ServiceImpl<ShoppingDao, Shopping> implements ShoppingService {

    public R selectShoppingById(int id) {
        System.out.println("id="+id);
        List<Shopping> shoppings = baseMapper.selectShoppingById((Integer) id);

        return R.ok(shoppings);
    }
}

