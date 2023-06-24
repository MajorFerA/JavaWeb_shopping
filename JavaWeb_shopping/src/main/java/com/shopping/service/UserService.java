package com.shopping.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shopping.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 14:11:05
 */
public interface UserService extends IService<User> {
       R login(User user);
       R update(User user);
}

