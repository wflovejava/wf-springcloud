package com.wf.common.idgen;

/**
 * @Author ：wf
 * @Date ：2020/5/29 9:59
 * @Describe：Id生成
 */
public abstract class IdGenerator {
    public IdGenerator(){
    }
    public abstract long newId();
}
