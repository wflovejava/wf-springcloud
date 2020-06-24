package com.wf.transaction.rocketmq.order.service.impl;

import com.wf.transaction.base.entity.FwTradeLog;
import com.wf.transaction.base.entity.FwTransactionLog;
import com.wf.transaction.base.enums.StatusEnum;
import com.wf.transaction.base.idgen.IdGenerator;
import com.wf.transaction.base.service.FwTradeLogService;
import com.wf.transaction.base.service.FwTransactionLogService;
import com.wf.transaction.rocketmq.order.service.OrderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


/**
 * @Author ：wf
 * @Date ：2020/6/8 13:17
 * @Describe：订单实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private FwTradeLogService fwTradeLogService;
    @Autowired
    private FwTransactionLogService fwTransactionLogService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private IdGenerator idGenerator;


    /**
     * 下单
     * @param productName
     */
    @Override
    public void saveAndPayOrder(String productName) {
        FwTradeLog fwTradeLog =new FwTradeLog(StatusEnum.TWO,idGenerator.newId(),idGenerator.newId(),new BigDecimal("100.00"));
        fwTradeLog.setProductId(System.currentTimeMillis());
        fwTradeLog.setProductName(productName);
        String transactionId = String.valueOf(idGenerator.newId());
        // 往RocketMQ发送事务消息
        this.rocketMQTemplate.sendMessageInTransaction(
                "wf-pay-order-group", // 事务消息分组，组名
                "pay-success", // 事务消息topic
                MessageBuilder.withPayload(fwTradeLog)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                        .build(), // 消息
                fwTradeLog // 额外参数，供后续回调使用
        );
    }

    /**
     * 支付
     * @param fwTradeLog
     * @param transactionId
     */
    @Override
    @Transactional
    public void payOrder(FwTradeLog fwTradeLog, String transactionId) {
        fwTradeLogService.insert(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.TWO.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());

        // 记录事务日志
        FwTransactionLog transactionLog = new FwTransactionLog();
        transactionLog.setTransactionId(transactionId);
        transactionLog.setId(idGenerator.newId());
        String remark = String.format("事务ID为%s的本地事务执行成功", transactionId);
        transactionLog.setRemark(remark);
        fwTransactionLogService.insert(transactionLog);
        log.info("事务ID=>{} 本地事务执行成功", transactionId);
//        int i=10/0;
    }
}
