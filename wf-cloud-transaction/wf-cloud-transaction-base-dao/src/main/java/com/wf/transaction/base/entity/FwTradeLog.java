package com.wf.transaction.base.entity;

import com.wf.transaction.base.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(FwTradeLog)实体类
 *
 * @author makejava
 * @since 2020-06-08 11:09:48
 */
public class FwTradeLog implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 主键id
    */
    private Object id;
    /**
    * 订单状态 1.待支付 2.待发货 3.待收货 4.订单完成 5.订单关闭
    */
    private Object status;
    /**
    * 状态描述
    */
    private String statusDsc;
    /**
    * 商品id
    */
    private Long productId;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 订单id
    */
    private Long orderId;
    /**
    * 订单总额
    */
    private BigDecimal orderAmount;
    /**
    * 创建时间
    */
    private Date createTime;

    public FwTradeLog(){

    }

    public FwTradeLog(StatusEnum status,Long userId,Long orderId,BigDecimal orderAmount ){
        this.id = userId;
        this.createTime = new Date();
        this.status = status.getValue();
        this.statusDsc=status.getDesc();
        this.orderAmount=orderAmount;
        this.userId=userId;
        this.orderId= orderId;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getStatusDsc() {
        return statusDsc;
    }

    public void setStatusDsc(String statusDsc) {
        this.statusDsc = statusDsc;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



}