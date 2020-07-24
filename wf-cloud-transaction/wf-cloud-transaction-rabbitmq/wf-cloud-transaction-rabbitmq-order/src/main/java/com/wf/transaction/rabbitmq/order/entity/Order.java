package com.wf.transaction.rabbitmq.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-07-21 16:30:01
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 344078002739068445L;
    /**
    * 订单号
    */
    private Long orderId;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 商品Id
    */
    private Long productId;
    /**
    * 订单名称
    */
    private String productName;
    /**
    * 订单状态1-待付款 2-待发货 3-待收货 4-订单完成 5-订单关闭
    */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}