package com.wf.transaction.rabbitmq.order.service.impl;

import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import com.wf.transaction.rabbitmq.order.dao.LocalMsgDao;
import com.wf.transaction.rabbitmq.order.service.LocalMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LocalMsg)表服务实现类
 *
 * @author makejava
 * @since 2020-07-23 09:59:01
 */
@Service("localMsgService")
public class LocalMsgServiceImpl implements LocalMsgService {
    @Resource
    private LocalMsgDao localMsgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    @Override
    public LocalMsg queryById(Long msgId) {
        return this.localMsgDao.queryById(msgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LocalMsg> queryAllByLimit(int offset, int limit) {
        return this.localMsgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param localMsg 实例对象
     * @return 实例对象
     */
    @Override
    public LocalMsg insert(LocalMsg localMsg) {
        this.localMsgDao.insert(localMsg);
        return localMsg;
    }

    /**
     * 修改数据
     *
     * @param localMsg 实例对象
     * @return 实例对象
     */
    @Override
    public LocalMsg update(LocalMsg localMsg) {
        this.localMsgDao.update(localMsg);
        return this.queryById(localMsg.getMsgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long msgId) {
        return this.localMsgDao.deleteById(msgId) > 0;
    }

    @Override
    public List<LocalMsg> queryAll(LocalMsg localMsg) {
        return localMsgDao.queryAll(localMsg);
    }
}