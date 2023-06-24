package com.shopping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 14:11:05
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    /**
     *
     */
    public R login(User user){
        R r = new R();
        //先根据用户名查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        List<User> users = baseMapper.selectList(queryWrapper);
        if (users==null||users.size()==0){//说明没有此用户
            r.setCode(400);
            r.setMsg("该用户没有注册");
            return r;
        }
        //判断是否有多个用户
        if (users.size()>1){//说明有两个账号一样的
            r.setCode(400);
            r.setMsg("账户异常");
            return r;
        }
         //再比较密码
        String password = users.get(0).getPassword();
        if (!password.equals(user.getPassword())){
            //密码错误
            r.setCode(400);
            r.setMsg("密码错误");
            return r;
        }
        r.setCode(200);
        r.setMsg("登录成功");
        r.setData(users.get(0));
        return r;
    }

    public R update(User user){
        R r = new R();
        if (updateById(user)) {
            r.setCode(200);
            r.setMsg("修改成功");
        } else {
            r.setCode(400);
            r.setMsg("修改失败");
        }
        return r;
    }
}

