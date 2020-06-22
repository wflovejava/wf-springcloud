package com.wf.transaction.base.service.impl;

import com.wf.transaction.base.entity.FwTradeLog;
import com.wf.transaction.base.dao.FwTradeLogDao;
import com.wf.transaction.base.service.FwTradeLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(FwTradeLog)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 11:09:51
 */
@Service("fwTradeLogService")
public class FwTradeLogServiceImpl implements FwTradeLogService {
    @Resource
    private FwTradeLogDao fwTradeLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FwTradeLog queryById(Object id) {
        return this.fwTradeLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<FwTradeLog> queryAllByLimit(int offset, int limit) {
        return this.fwTradeLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param fwTradeLog 实例对象
     * @return 实例对象
     */
    @Override
    public FwTradeLog insert(FwTradeLog fwTradeLog) {
        this.fwTradeLogDao.insert(fwTradeLog);
        return fwTradeLog;
    }

    /**
     * 修改数据
     *
     * @param fwTradeLog 实例对象
     * @return 实例对象
     */
    @Override
    public FwTradeLog update(FwTradeLog fwTradeLog) {
        this.fwTradeLogDao.update(fwTradeLog);
        return this.queryById(fwTradeLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.fwTradeLogDao.deleteById(id) > 0;
    }
}