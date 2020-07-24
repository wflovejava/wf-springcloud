package com.wf.transaction.rabbitmq.send.service;

import com.wf.transaction.rabbitmq.send.entity.Message;

/**
 * 消息消费
 */
public interface MessageReceiver {
    void receiver(String msg);
}
