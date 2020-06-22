package com.wf.transaction.rocketmq.send.service;

import com.wf.transaction.*;
import com.wf.transaction.base.entity.FwTradeLog;

public interface PayService {

    /**
     * 支付订单
     */
    void payOrder(FwTradeLog fwTradeLog);

}