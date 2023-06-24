package com.shopping.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2021-12-02 14:11:07
 */
@SuppressWarnings("serial")
@TableName("orders")
public class Order extends Model<Order> {
    //订单序列号
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //用户id
    private Integer uid;
    //商品id
    private Integer gid;
    //订单时间
    private String time;
    //订单状态
    private String status;
    //商品数量
    private Integer num;

    private double price;
    private double total;

    private String goodname;

    private String img;

    private String receiver;

    private String phone;

    private String shippingaddr;

    private Integer ostate;

    private Integer score;

    private String evaluation;

    private String evaluatetime;


    public String getImg() {
        return img;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getEvaluatetime() {
        return evaluatetime;
    }

    public void setEvaluatetime(String evaluatetime) {
        this.evaluatetime = evaluatetime;
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

