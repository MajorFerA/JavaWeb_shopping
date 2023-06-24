package com.shopping.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.shopping.entity.Shopping;
import com.shopping.service.ShoppingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (Shoping)表控制层
 *
 * @author makejava
 * @since 2021-12-02 14:11:07
 */
@RestController
@RequestMapping("shopping")
public class ShoppingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingService shoppingService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param shopping 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Shopping> page, Shopping shopping) {
        return success(this.shoppingService.page(page, new QueryWrapper<>(shopping)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shoppingService.getById(id));
    }

    /**
     * 查询用户的购物车
     */
    @GetMapping("info/{id}")
    public R selectShoppingrById(@PathVariable("id") int id) {
        return shoppingService.selectShoppingById(id);
    }

    /**
     * 新增数据
     *
     * @param shopping 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Shopping shopping) {
        return success(this.shoppingService.save(shopping));
    }

    /**
     * 修改数据
     *
     * @param shopping 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Shopping shopping) {
        return success(this.shoppingService.updateById(shopping));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("id") Long idList) {
        return success(this.shoppingService.removeById(idList));
    }
}

