//package com.wf.transaction.base.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import java.io.IOException;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public HikariDataSource dataSource(){
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setPoolName("POOL1");
//        return dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(HikariDataSource dataSource) throws IOException {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config/mybatis-config.xml"));
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
//        return bean;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.wf.transaction.base.dao");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        return mapperScannerConfigurer;
//    }
//
//}
