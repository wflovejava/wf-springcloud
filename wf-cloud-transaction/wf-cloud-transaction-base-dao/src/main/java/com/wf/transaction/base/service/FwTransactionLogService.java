package com.wf.transaction.base.service;

import com.wf.transaction.base.entity.FwTransactionLog;
import java.util.List;

/**
 * (FwTransactionLog)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 11:09:52
 */
public interface FwTransactionLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FwTransactionLog queryById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    FwTransactionLog queryByTransactionId(Long transactionId);
    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<FwTransactionLog> queryAll(FwTransactionLog fwTransactionLog);

    /**
     * 新增数据
     *
     * @param fwTransactionLog 实例对象
     * @return 实例对象
     */
    FwTransactionLog insert(FwTransactionLog fwTransactionLog);

    /**
     * 修改数据
     *
     * @param fwTransactionLog 实例对象
     * @return 实例对象
     */
    FwTransactionLog update(FwTransactionLog fwTransactionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}