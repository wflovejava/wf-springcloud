package com.wf.transaction.rabbitmq.send.entity;

import java.io.Serializable;

/**
 * (Waybill)实体类
 *
 * @author makejava
 * @since 2020-07-21 16:32:54
 */
public class Waybill implements Serializable {
    private static final long serialVersionUID = -70425010227520737L;
    /**
    * 运单号
    */
    private Long waybillId;
    /**
    * 订单号
    */
    private Long orderId;
    /**
    * 运单人
    */
    private Long waybillUserId;
    /**
    * 配送状态0-未配送 1-配送中 2-完成
    */
    private Integer status;


    public Long getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWaybillUserId() {
        return waybillUserId;
    }

    public void setWaybillUserId(Long waybillUserId) {
        this.waybillUserId = waybillUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}