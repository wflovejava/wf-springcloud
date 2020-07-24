package com.wf.transaction.rabbitmq.order.controller;

import com.wf.common.util.JsonUtils;
import com.wf.transaction.base.idgen.IdGenerator;
import com.wf.transaction.rabbitmq.order.entity.Message;
import com.wf.transaction.rabbitmq.order.entity.Order;
import com.wf.transaction.rabbitmq.order.service.MessageSender;
import com.wf.transaction.rabbitmq.order.service.OrderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2020-07-21 16:30:04
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    MessageSender messageSender;


    @Autowired
    IdGenerator idGenerator;
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }



    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("/save")
    public String save() {
        Order order = new Order();
        order.setOrderId(idGenerator.newId());
        order.setProductId(2L);
        order.setProductName("华为手机p30");
        order.setStatus(1);
        order.setUserId(101L);
        order.setCreateTime(new Date());
        orderService.insert(order);

        Message message = new Message();
        message.setBody(JsonUtils.toText(order));
        message.setSendTime(new Date());
        messageSender.send(message);
        return "下单成功";
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("/deadLetter")
    public String deadLetter() {

        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            // 设置编码
            messageProperties.setContentEncoding("utf-8");
            // 设置过期时间3*1000毫秒
            messageProperties.setExpiration("5000");
            return message;
        };
        Order order = new Order();
        order.setOrderId(idGenerator.newId());
        order.setProductId(2L);
        order.setProductName("华为手机p30");
        order.setStatus(1);
        order.setUserId(101L);
        order.setCreateTime(new Date());
        orderService.insert(order);

        Message message = new Message();
        message.setBody(JsonUtils.toText(order));
        message.setSendTime(new Date());
        CorrelationData correlationData = new CorrelationData(String.valueOf(idGenerator.newId()));

        rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", JsonUtils.toText(message), messagePostProcessor, correlationData);
        return "下单成功";
    }

}