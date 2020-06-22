package com.wf.transaction.base.config;

import com.wf.transaction.base.idgen.IdGenerator;
import com.wf.transaction.base.idgen.SnowFlakeIdGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：wf
 * @Date ：2020/5/28 13:52
 * @Describe：
 */
@Configuration
@MapperScan(value = "com.wf.transaction.base.dao")
public class MybatisPlusConfig {

    @Bean
    public IdGenerator idGenerator() {
        return new SnowFlakeIdGenerator(1, 1);
    }
}
