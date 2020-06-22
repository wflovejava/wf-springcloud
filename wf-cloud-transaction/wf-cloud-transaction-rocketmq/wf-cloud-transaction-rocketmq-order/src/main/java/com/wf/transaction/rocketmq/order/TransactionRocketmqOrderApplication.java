package com.wf.transaction.rocketmq.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：wf
 * @Date ：2020/6/8 11:16
 * @Describe：
 */
@SpringBootApplication(scanBasePackages = {"com.wf.transaction.base","com.wf.transaction.rocketmq.order"})
public class TransactionRocketmqOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionRocketmqOrderApplication.class);
    }
}
