package com.wf.transaction.rabbitmq.order.config;

import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import com.wf.transaction.rabbitmq.order.service.LocalMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：wf
 * @Date ：2020/7/22 14:06
 * @Describe：rabbitmq配置
 */
@Configuration
@Slf4j
public class RabbitMQConfig {
    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    LocalMsgService localMsgService;

    /**
     * 发货单队列描述
     */
    //发货单队列名称
    public static final String WAYBILL_QUEUE_NAME = "waybill.queue";
    //发送货路由器
    public static final String WAYBILL_EXCHANGE_NAME = "waybill.exchange";
    //发送货路由键
    public static final String WAYBILL_ROUTING_KEY_NAME = "waybill.routing.key";


    /**
     * 定义rabbitmq模板 确保消息投递100%
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        //消息是否发送Exchange上
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            //发送消息成功
            if(ack){
                log.info("消息发送到Exchange");
                String msgId = correlationData.getId();
                log.info("msgId：{}",msgId);
                LocalMsg localMsg = new LocalMsg();
                localMsg.setStatus(1);
                localMsg.setMsgId(Long.parseLong(msgId));
                //修改本地消息表的状态 已发送成功状态
                localMsgService.update(localMsg);
            }else {//发送消息失败 对应发送失败的消息，方案定时检测
                log.info("消息发送到Exchange失败, {}, cause: {}", correlationData, cause);
            }
        });

        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


    /**
     * 定义string队列
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue("test");
    }


    /**
     * 定义个发货单队列
     * @return
     */
    @Bean
    public Queue wayBillQueue() {
        return new Queue(WAYBILL_QUEUE_NAME, true);
    }

    /**
     * 定义个发货单队列路由器
     * @return
     */
    @Bean
    public DirectExchange wayBillExchange() {
        return new DirectExchange(WAYBILL_EXCHANGE_NAME, true, false);
    }

    /**
     * 绑定发货单队列和发货单路由器
     * @return
     */
    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(wayBillQueue()).to(wayBillExchange()).with(WAYBILL_ROUTING_KEY_NAME);
    }
}
