package com.wf.transaction.rabbitmq.send.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ：wf
 * @Date ：2020/7/22 9:02
 * @Describe：消息类
 */
@Data
public class Message implements Serializable {

    /**
     * 消息Id
     */
    private Long msgId;

    /**
     * 消息内容
     */
    private String body;

    /**
     * 消息状态 0-未发送 1-已发送
     */
    private int status;


    /**
     * 发送消息时间
     */
    private Date sendTime;


}
