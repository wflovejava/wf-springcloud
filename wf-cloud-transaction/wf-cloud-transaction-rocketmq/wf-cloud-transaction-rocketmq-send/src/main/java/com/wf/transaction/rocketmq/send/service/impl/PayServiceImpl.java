package com.wf.transaction.rocketmq.send.service.impl;

import com.wf.transaction.*;
import com.wf.transaction.base.entity.FwTradeLog;
import com.wf.transaction.base.enums.StatusEnum;
import com.wf.transaction.base.service.FwTradeLogService;
import com.wf.transaction.rocketmq.send.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class PayServiceImpl implements PayService {
    private static Logger log = LoggerFactory.getLogger(PayServiceImpl.class);


    @Autowired
    private FwTradeLogService fwTradeLogService;

    @Override
    @Transactional
    public void payOrder(FwTradeLog fwTradeLog) {
        fwTradeLog.setStatus(StatusEnum.THREE.getValue());
        fwTradeLog.setStatusDsc(StatusEnum.THREE.getDesc());
        fwTradeLogService.insert(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.THREE.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());
        int i=10/0;
    }
}