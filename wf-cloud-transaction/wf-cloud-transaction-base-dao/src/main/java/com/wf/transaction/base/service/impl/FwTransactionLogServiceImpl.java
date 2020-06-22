package com.wf.transaction.base.service.impl;

import com.wf.transaction.base.entity.FwTransactionLog;
import com.wf.transaction.base.dao.FwTransactionLogDao;
import com.wf.transaction.base.service.FwTransactionLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FwTransactionLog)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 11:09:52
 */
@Service("fwTransactionLogService")
public class FwTransactionLogServiceImpl implements FwTransactionLogService {
    @Resource
    private FwTransactionLogDao fwTransactionLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FwTransactionLog queryById(Long id) {
        return this.fwTransactionLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<FwTransactionLog> queryAll(FwTransactionLog fwTransactionLog) {
        return this.fwTransactionLogDao.queryAll(fwTransactionLog);
    }

    /**
     * 新增数据
     *
     * @param fwTransactionLog 实例对象
     * @return 实例对象
     */
    @Override
    public FwTransactionLog insert(FwTransactionLog fwTransactionLog) {
        this.fwTransactionLogDao.insert(fwTransactionLog);
        return fwTransactionLog;
    }

    /**
     * 修改数据
     *
     * @param fwTransactionLog 实例对象
     * @return 实例对象
     */
    @Override
    public FwTransactionLog update(FwTransactionLog fwTransactionLog) {
        this.fwTransactionLogDao.update(fwTransactionLog);
        return this.queryById(fwTransactionLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.fwTransactionLogDao.deleteById(id) > 0;
    }

    @Override
    public FwTransactionLog queryByTransactionId(Long transactionId) {
      return   this.fwTransactionLogDao.queryByTransactionId(transactionId);
    }
}