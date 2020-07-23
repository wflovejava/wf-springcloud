package com.wf.transaction.rabbitmq.send.service;

import com.wf.transaction.rabbitmq.send.entity.Waybill;
import java.util.List;

/**
 * (Waybill)表服务接口
 *
 * @author makejava
 * @since 2020-07-21 16:32:55
 */
public interface WaybillService {

    /**
     * 通过ID查询单条数据
     *
     * @param waybillId 主键
     * @return 实例对象
     */
    Waybill queryById(Long waybillId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Waybill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param waybill 实例对象
     * @return 实例对象
     */
    Waybill insert(Waybill waybill);

    /**
     * 修改数据
     *
     * @param waybill 实例对象
     * @return 实例对象
     */
    Waybill update(Waybill waybill);

    /**
     * 通过主键删除数据
     *
     * @param waybillId 主键
     * @return 是否成功
     */
    boolean deleteById(Long waybillId);

}