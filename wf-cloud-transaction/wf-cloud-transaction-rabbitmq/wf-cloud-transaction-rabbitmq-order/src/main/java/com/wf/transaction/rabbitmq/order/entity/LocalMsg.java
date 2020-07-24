package com.wf.transaction.rabbitmq.order.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LocalMsg)实体类
 *
 * @author makejava
 * @since 2020-07-23 09:59:01
 */
public class LocalMsg implements Serializable {
    private static final long serialVersionUID = 757223244907783478L;
    /**
    * 消息id
    */
    private Long msgId;
    /**
    * 消息内容
    */
    private String body;
    /**
    * 消息状态 0-未发送 1-已发送 2-消费成功
    */
    private Integer status;
    /**
    * 消息发送时间
    */
    private Date sendTime;


    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

}