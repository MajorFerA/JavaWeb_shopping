package com.shopping.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopping.entity.Order;
import com.shopping.service.OrderService;
import com.shopping.service.ShoppingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-12-02 14:11:06
 */
@RestController
@RequestMapping("order")
public class OrderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Resource
    private ShoppingService shopingService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param order 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Order> page, Order order) {
        return success(this.orderService.page(page, new QueryWrapper<>(order)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.orderService.getById(id));
    }

    //查询客户订单
    @GetMapping("info/{id}")
    public R selectOrderById(@PathVariable("id") int id) {
        return orderService.selectOrderById(id);
    }

    /**
     * 新增数据
     *
     * @param order 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Order order) {
        Integer id = order.getId(); //删除购物车里面的 Id 数据
        boolean b = shopingService.removeById(id);
        System.out.println("删除购物的id =>" + id);
        System.out.println("getId =>" + order.getId());
        System.out.println("getGid =>" + order.getGid());
        return success(this.orderService.save(order));
    }

    /**
     * 修改数据
     *
     * @param order 实体对象
     * @return 修改结果
     */
    @PostMapping("/evaluate")
    public R update(@RequestBody Order order) {
        //System.out.println("order.getId() =>" + order.getId());
        //System.out.println("order.getEvaluation() =>" + order.getEvaluation());
        //System.out.println("order.getScore() =>" + order.getScore());

        Order mOrder = new Order();
        Date date = new Date();
        String time = date.toLocaleString();
        System.out.println("time =>" + time);
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String sim_time = dateFormat.format(date);
        //System.out.println("sim_time =>" + sim_time);
        mOrder.setId(order.getId());
        mOrder.setPrice(order.getPrice());
        mOrder.setNum(order.getNum());
        mOrder.setTotal(order.getTotal());
        mOrder.setOstate(1);
        mOrder.setEvaluation(order.getEvaluation());
        mOrder.setScore(order.getScore());
        mOrder.setEvaluatetime(time);
        return success(this.orderService.updateById(mOrder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("id") Long idList) {
        return success(this.orderService.removeById(idList));
    }
}

