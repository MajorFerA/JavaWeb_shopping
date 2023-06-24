package com.shopping.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shopping.entity.User;
import com.shopping.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-12-02 14:11:04
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */

    @PostMapping("/register")
    public R insert(@RequestBody User user) {
        //判断是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        List<User> admins = userService.list(queryWrapper);
        R r = new R();
        if (admins.size() > 0) {//说明用户已经存在了 不然他重新添加 啊哈哈

            r.setCode(400);
            r.setMsg("该用户名已占用");
            return r;
        }
        userService.save(user);
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("username", user.getUsername());
        r.setData(userService.list(queryWrapper2));
        r.setMsg("注册成功");
        return r;
    }

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    //@PutMapping
    @PostMapping("/update")
    public R update(@RequestBody User user) {
        System.out.println("admin.getId() =>" + user.getId());
        System.out.println("admin.getUsername() =>" + user.getUsername());
        System.out.println("admin.getPassword() =>" + user.getPassword());
        return userService.update(user);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }
}

