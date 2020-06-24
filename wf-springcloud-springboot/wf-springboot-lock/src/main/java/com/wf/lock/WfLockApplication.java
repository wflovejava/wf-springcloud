package com.wf.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：wf
 * @Date ：2020/6/23 9:51
 * @Describe：分布式锁
 */
@SpringBootApplication
public class WfLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(WfLockApplication.class);
        System.out.println("WfLockApplication server ok !");
    }
}
