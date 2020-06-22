package com.wf.transaction.base.service;

import com.wf.transaction.base.entity.FwTradeLog;
import java.util.List;

/**
 * 订单表(FwTradeLog)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 11:09:50
 */
public interface FwTradeLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FwTradeLog queryById(Object id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FwTradeLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param fwTradeLog 实例对象
     * @return 实例对象
     */
    FwTradeLog insert(FwTradeLog fwTradeLog);

    /**
     * 修改数据
     *
     * @param fwTradeLog 实例对象
     * @return 实例对象
     */
    FwTradeLog update(FwTradeLog fwTradeLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);

}