package com.wf.transaction.rocketmq.order.service;

import com.wf.transaction.base.entity.FwTradeLog;

/**
 * @Author ：wf
 * @Date ：2020/6/8 13:14
 * @Describe：订单接口
 */
public interface OrderService {

    /**
     * 下单
     */
    void saveAndPayOrder(String productName);

    /**
     * 支付
     */
    void payOrder(FwTradeLog fwTradeLog, String transactionId);

}
