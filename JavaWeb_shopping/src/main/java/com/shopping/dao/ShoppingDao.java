package com.shopping.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shopping.entity.Shopping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Shoping)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-02 14:11:07
 */
public interface ShoppingDao extends BaseMapper<Shopping> {
    List<Shopping> selectShoppingById(@Param("id") int id);
}

