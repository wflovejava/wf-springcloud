package com.wf.transaction.rabbitmq.send.service.impl;

import com.wf.common.util.JsonUtils;
import com.wf.transaction.rabbitmq.send.entity.Message;
import com.wf.transaction.rabbitmq.send.service.MessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author ：wf
 * @Date ：2020/7/22 9:35
 * @Describe： rabbitmq消费消息
 */
@Component
@Slf4j
public class RabbitMqMessageReceiver implements MessageReceiver {

    @Override
    @RabbitHandler
    @RabbitListener(queues = "test")
    public void receiver(String msg) {

        System.out.println("========"+JsonUtils.toText(msg));
        log.info("receiver:{}", JsonUtils.toText(msg));
    }
}
