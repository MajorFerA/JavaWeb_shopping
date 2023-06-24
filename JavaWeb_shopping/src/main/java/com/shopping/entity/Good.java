package com.shopping.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Good)表实体类
 *
 * @author makejava
 * @since 2021-12-02 14:11:06
 */
@SuppressWarnings("serial")
public class Good extends Model<Good> {
    //商品Id
    @TableId(value = "gid",type = IdType.AUTO)
    private Integer gid;
    //商品姓名
    private String goodname;
    //商品价格
    private Double price;
    //商品说明
    private String info;
    //图片路径
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.gid;
    }
}

