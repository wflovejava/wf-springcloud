package com.wf.transaction.rabbitmq.order.service;

/**
 * @Author ：wf
 * @Date ：2020/7/23 10:46
 * @Describe： 定时任务，重新投递发送失败的消息
 */
public interface ResendMsgService {

    /**
     * 定时任务，重新投递发送失败的消息
     */
      void resend();

    }
