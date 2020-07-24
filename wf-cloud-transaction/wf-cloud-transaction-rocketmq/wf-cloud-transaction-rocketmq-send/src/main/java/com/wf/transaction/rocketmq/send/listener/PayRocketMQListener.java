package com.wf.transaction.rocketmq.send.listener;


import com.wf.transaction.base.entity.FwTradeLog;
import com.wf.transaction.rocketmq.send.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "wf-pay-order-group", topic = "pay-success")
public class PayRocketMQListener implements RocketMQListener<FwTradeLog> {
    private static Logger log = LoggerFactory.getLogger(PayRocketMQListener.class);

    @Autowired
    private PayService payService;


    @Override
    public void onMessage(FwTradeLog fwTradeLog) {
        log.info("监听到用户已经下单成功订单id=>{}，名称=>{}的商品", fwTradeLog.getOrderId(), fwTradeLog.getProductName());
        payService.payOrder(fwTradeLog);
    }

}
