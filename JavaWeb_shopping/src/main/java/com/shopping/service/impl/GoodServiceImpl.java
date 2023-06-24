package com.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopping.dao.GoodDao;
import com.shopping.entity.Good;
import com.shopping.service.GoodService;
import org.springframework.stereotype.Service;

/**
 * (Good)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 14:11:06
 */
@Service("goodService")
public class GoodServiceImpl extends ServiceImpl<GoodDao, Good> implements GoodService {

}

