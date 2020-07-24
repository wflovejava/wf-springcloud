package com.wf.transaction.rabbitmq.send;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于rabbitmq 实现分布式事务 运单服务
 * @Author ：wf
 * @Date ：2020/7/21 16:12
 * @Describe：
 */
@SpringBootApplication(scanBasePackages = {"com.wf.transaction.base","com.wf.transaction.rabbitmq.send"})
@MapperScan(basePackages = {"com.wf.transaction.rabbitmq.*.dao"})
public class RabbitmqSendApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSendApplication.class, args);
    }

}
