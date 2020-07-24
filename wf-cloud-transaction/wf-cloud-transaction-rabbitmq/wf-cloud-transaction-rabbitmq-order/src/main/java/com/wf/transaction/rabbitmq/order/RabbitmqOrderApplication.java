package com.wf.transaction.rabbitmq.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 基于rabbitmq 实现分布式事务 订单服务
 * @Author ：wf
 * @Date ：2020/7/21 16:12
 * @Describe：
 */
@SpringBootApplication(scanBasePackages = {"com.wf.transaction.base","com.wf.transaction.rabbitmq.order"})
@MapperScan(basePackages = {"com.wf.transaction.rabbitmq.*.dao"})
@EnableScheduling
public class RabbitmqOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqOrderApplication.class, args);
    }
}
