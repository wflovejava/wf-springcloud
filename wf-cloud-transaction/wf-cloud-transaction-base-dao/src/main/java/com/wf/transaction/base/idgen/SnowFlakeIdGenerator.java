package com.wf.transaction.base.idgen;

/**
 * @Author ：wf
 * @Date ：2020/5/29 10:01
 * @Describe：ID生成实现类
 */
public class SnowFlakeIdGenerator  extends  IdGenerator{


    private long datacenterId;
    private long machineId;
    private SnowFlake snowFlake;

    public SnowFlakeIdGenerator() {
        this.datacenterId = 1L;
        this.machineId = 1L;
        this.snowFlake = new SnowFlake(this.datacenterId, this.machineId);
    }

    public SnowFlakeIdGenerator(long datacenterId, long machineId) {
        this.datacenterId = datacenterId;
        this.machineId = machineId;
        this.snowFlake = new SnowFlake(datacenterId, machineId);
    }

    public long newId() {
        long id = this.snowFlake.nextId();
        return id;
    }
}
