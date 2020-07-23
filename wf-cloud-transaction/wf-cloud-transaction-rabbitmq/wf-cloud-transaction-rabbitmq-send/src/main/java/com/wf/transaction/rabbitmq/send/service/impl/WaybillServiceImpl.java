package com.wf.transaction.rabbitmq.send.service.impl;

import com.wf.transaction.rabbitmq.send.entity.Waybill;
import com.wf.transaction.rabbitmq.send.dao.WaybillDao;
import com.wf.transaction.rabbitmq.send.service.WaybillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Waybill)表服务实现类
 *
 * @author makejava
 * @since 2020-07-21 16:32:56
 */
@Service("waybillService")
public class WaybillServiceImpl implements WaybillService {
    @Resource
    private WaybillDao waybillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param waybillId 主键
     * @return 实例对象
     */
    @Override
    public Waybill queryById(Long waybillId) {
        return this.waybillDao.queryById(waybillId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Waybill> queryAllByLimit(int offset, int limit) {
        return this.waybillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param waybill 实例对象
     * @return 实例对象
     */
    @Override
    public Waybill insert(Waybill waybill) {
        this.waybillDao.insert(waybill);
        return waybill;
    }

    /**
     * 修改数据
     *
     * @param waybill 实例对象
     * @return 实例对象
     */
    @Override
    public Waybill update(Waybill waybill) {
        this.waybillDao.update(waybill);
        return this.queryById(waybill.getWaybillId());
    }

    /**
     * 通过主键删除数据
     *
     * @param waybillId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long waybillId) {
        return this.waybillDao.deleteById(waybillId) > 0;
    }
}