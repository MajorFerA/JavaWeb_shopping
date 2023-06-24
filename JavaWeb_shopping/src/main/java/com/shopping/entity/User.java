package com.shopping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-12-02 14:11:05
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String shippingaddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getShippingaddr() {
        return shippingaddr;
    }

    public void setShippingaddr(String shippingaddr) {
        this.shippingaddr = shippingaddr;
    }


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

