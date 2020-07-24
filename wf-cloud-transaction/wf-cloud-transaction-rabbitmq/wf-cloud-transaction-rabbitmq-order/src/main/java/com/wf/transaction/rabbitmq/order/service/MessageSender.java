package com.wf.transaction.rabbitmq.order.service;

import com.wf.transaction.rabbitmq.order.entity.Message;

/**
 * 消息发送者
 */
public interface MessageSender {

    void send(Message message);

    void resend(Message message);
}
