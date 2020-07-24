package com.wf.transaction.rabbitmq.order.service.impl;

import com.wf.common.util.BeanCopyUtil;
import com.wf.common.util.JsonUtils;
import com.wf.transaction.base.idgen.IdGenerator;
import com.wf.transaction.rabbitmq.order.config.RabbitMQConfig;
import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import com.wf.transaction.rabbitmq.order.entity.Message;
import com.wf.transaction.rabbitmq.order.service.LocalMsgService;
import com.wf.transaction.rabbitmq.order.service.MessageSender;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：wf
 * @Date ：2020/7/22 9:03
 * @Describe： 消息发送者实现类
 */
@Service("MessageSenderService")
public class RabbitMqMessageSendImpl implements MessageSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    LocalMsgService localMsgService;

    /**
     * 发送消息
     * @param message
     */
    @Override
    public void send(Message message) {
        message.setMsgId(idGenerator.newId());
        LocalMsg localMsg  = BeanCopyUtil.copy(message,LocalMsg.class);
        localMsg.setStatus(0);//默认发送mq失败状态
        //保存本地消息
        localMsgService.insert(localMsg);
        CorrelationData correlationData = new CorrelationData(String.valueOf(message.getMsgId()));
        //发送rabbitmq消息
        rabbitTemplate.convertAndSend(RabbitMQConfig.WAYBILL_EXCHANGE_NAME,RabbitMQConfig.WAYBILL_ROUTING_KEY_NAME, JsonUtils.toText(message),correlationData);
    }

    /**
     * 重发消息
     * @param message
     */
    @Override
    public void resend(Message message) {
        CorrelationData correlationData = new CorrelationData(String.valueOf(message.getMsgId()));
        //发送rabbitmq消息
        rabbitTemplate.convertAndSend(RabbitMQConfig.WAYBILL_EXCHANGE_NAME,RabbitMQConfig.WAYBILL_ROUTING_KEY_NAME, JsonUtils.toText(message),correlationData);
    }
}
