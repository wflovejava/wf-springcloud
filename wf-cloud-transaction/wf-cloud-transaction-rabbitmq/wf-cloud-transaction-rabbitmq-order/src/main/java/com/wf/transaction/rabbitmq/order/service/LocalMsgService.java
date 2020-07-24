package com.wf.transaction.rabbitmq.order.service;

import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import java.util.List;

/**
 * (LocalMsg)表服务接口
 *
 * @author makejava
 * @since 2020-07-23 09:59:01
 */
public interface LocalMsgService {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    LocalMsg queryById(Long msgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LocalMsg> queryAllByLimit(int offset, int limit);

    /**
     * 查询多条数据
     *
     * @param localMsg
     * @return 对象列表
     */
    List<LocalMsg> queryAll(LocalMsg localMsg);

    /**
     * 新增数据
     *
     * @param localMsg 实例对象
     * @return 实例对象
     */
    LocalMsg insert(LocalMsg localMsg);

    /**
     * 修改数据
     *
     * @param localMsg 实例对象
     * @return 实例对象
     */
    LocalMsg update(LocalMsg localMsg);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    boolean deleteById(Long msgId);

}