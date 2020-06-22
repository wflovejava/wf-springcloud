package com.wf.transaction.rocketmq.order.controller;

import com.wf.transaction.rocketmq.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：wf
 * @Date ：2020/6/8 13:55
 * @Describe：订单接口
 */
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 下单 提交订单
     * @return
     */
    @GetMapping("/saveOrder")
    public String saveOrder(String productName){
        orderService.saveAndPayOrder(productName);
        return "ok";
    }

}
