package com.wf.transaction.rocketmq.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.wf.transaction.base","com.wf.transaction.rocketmq.send"})
public class WfTransactionRocketmqPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WfTransactionRocketmqPayApplication.class, args);
    }


}