package com.wf.transaction.rabbitmq.order.service.impl;

import com.wf.common.util.BeanCopyUtil;
import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import com.wf.transaction.rabbitmq.order.entity.Message;
import com.wf.transaction.rabbitmq.order.service.LocalMsgService;
import com.wf.transaction.rabbitmq.order.service.MessageSender;
import com.wf.transaction.rabbitmq.order.service.ResendMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author ：wf
 * @Date ：2020/7/23 10:47
 * @Describe：
 */
@Service("resendMsgService")
@Slf4j
public class ResendMsgServiceImpl implements ResendMsgService {

    @Autowired
    LocalMsgService localMsgService;

    @Autowired
    MessageSender messageSender;

    /**
     * 每3s拉取投递失败的消息, 重新投递
     */
    @Scheduled(cron = "0/3 * * * * ?")
    @Override
    public void resend() {
        LocalMsg localMsg = new LocalMsg();
        localMsg.setStatus(0);
        final List<LocalMsg> localMsgs = localMsgService.queryAll(localMsg);
        localMsgs.forEach(msg -> {
            Message message = BeanCopyUtil.copy(msg, Message.class);
            log.info("重新投递失败的消息 {}",message.getMsgId());
            messageSender.resend(message);
            //重发3次失败，进入私信队列

        });

    }
}
