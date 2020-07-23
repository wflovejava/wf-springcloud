package com.wf.transaction.rabbitmq.send.dao;

import com.wf.transaction.rabbitmq.send.entity.Waybill;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Waybill)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-21 16:32:55
 */
public interface WaybillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param waybillId 主键
     * @return 实例对象
     */
    Waybill queryById(Long waybillId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Waybill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param waybill 实例对象
     * @return 对象列表
     */
    List<Waybill> queryAll(Waybill waybill);

    /**
     * 新增数据
     *
     * @param waybill 实例对象
     * @return 影响行数
     */
    int insert(Waybill waybill);

    /**
     * 修改数据
     *
     * @param waybill 实例对象
     * @return 影响行数
     */
    int update(Waybill waybill);

    /**
     * 通过主键删除数据
     *
     * @param waybillId 主键
     * @return 影响行数
     */
    int deleteById(Long waybillId);

}