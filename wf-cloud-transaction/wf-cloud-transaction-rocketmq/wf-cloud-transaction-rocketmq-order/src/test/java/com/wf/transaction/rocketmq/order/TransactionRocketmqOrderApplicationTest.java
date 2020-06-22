package com.wf.transaction.rocketmq.order;

import com.wf.transaction.base.service.FwTradeLogService;
import com.wf.transaction.rocketmq.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author ：wf
 * @Date ：2020/6/8 11:27
 * @Describe：
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransactionRocketmqOrderApplication.class)
public class TransactionRocketmqOrderApplicationTest {
    /**
     * 服务对象
     */
    @Autowired
    private FwTradeLogService fwTradeLogService;

    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        orderService.saveAndPayOrder("dd");
    }
}
