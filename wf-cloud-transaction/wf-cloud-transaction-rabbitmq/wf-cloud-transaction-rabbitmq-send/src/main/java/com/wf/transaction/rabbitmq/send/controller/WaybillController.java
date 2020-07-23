package com.wf.transaction.rabbitmq.send.controller;

import com.wf.transaction.rabbitmq.send.entity.Waybill;
import com.wf.transaction.rabbitmq.send.service.WaybillService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Waybill)表控制层
 *
 * @author makejava
 * @since 2020-07-21 16:32:56
 */
@RestController
@RequestMapping("waybill")
public class WaybillController {
    /**
     * 服务对象
     */
    @Resource
    private WaybillService waybillService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Waybill selectOne(Long id) {
        return this.waybillService.queryById(id);
    }

}