package com.wf.transaction.rabbitmq.order.dao;

import com.wf.transaction.rabbitmq.order.entity.LocalMsg;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (LocalMsg)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-23 09:59:01
 */
public interface LocalMsgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    LocalMsg queryById(Long msgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LocalMsg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param localMsg 实例对象
     * @return 对象列表
     */
    List<LocalMsg> queryAll(LocalMsg localMsg);

    /**
     * 新增数据
     *
     * @param localMsg 实例对象
     * @return 影响行数
     */
    int insert(LocalMsg localMsg);

    /**
     * 修改数据
     *
     * @param localMsg 实例对象
     * @return 影响行数
     */
    int update(LocalMsg localMsg);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 影响行数
     */
    int deleteById(Long msgId);

}