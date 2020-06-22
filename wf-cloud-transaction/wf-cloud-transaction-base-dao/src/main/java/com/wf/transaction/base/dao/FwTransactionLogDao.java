package com.wf.transaction.base.dao;

import com.wf.transaction.base.entity.FwTransactionLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (FwTransactionLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 11:09:52
 */
public interface FwTransactionLogDao {

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
     * 通过实体作为筛选条件查询
     *
     * @param fwTransactionLog 实例对象
     * @return 对象列表
     */
    List<FwTransactionLog> queryAll(FwTransactionLog fwTransactionLog);

    /**
     * 新增数据
     *
     * @param fwTransactionLog 实例对象
     * @return 影响行数
     */
    int insert(FwTransactionLog fwTransactionLog);

    /**
     * 修改数据
     *
     * @param fwTransactionLog 实例对象
     * @return 影响行数
     */
    int update(FwTransactionLog fwTransactionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}