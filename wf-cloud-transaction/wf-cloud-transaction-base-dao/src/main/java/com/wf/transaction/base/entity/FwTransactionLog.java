package com.wf.transaction.base.entity;

import java.io.Serializable;

/**
 * (FwTransactionLog)实体类
 *
 * @author makejava
 * @since 2020-06-08 11:09:52
 */
public class FwTransactionLog implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;
    /**
    * 事务id
    */
    private String transactionId;
    /**
    * 备注
    */
    private String remark;

    public FwTransactionLog(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}