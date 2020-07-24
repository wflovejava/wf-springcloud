package com.wf.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：wf
 * @Date ：2020/6/28 10:40
 * @Describe：
 */
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {

        SpringApplication.run(GateWayApplication.class);
        System.out.println("GateWayApplication server run ok! ");
    }
}
