package com.wf.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：wf
 * @Date ：2020/6/23 13:59
 * @Describe：启动类
 */
@SpringBootApplication(scanBasePackages = {"com.wf.common"})
public class WFCommonApplication {
    public static void main(String[] args) {

        SpringApplication.run(WFCommonApplication.class);
        System.out.println("WFJwtApplication 启动 OK！");
    }
}
