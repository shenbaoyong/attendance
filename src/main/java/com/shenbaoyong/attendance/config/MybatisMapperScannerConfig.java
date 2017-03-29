package com.shenbaoyong.attendance.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)   //由于MapperScannerConfiguer执行的较早，所以必须有本注解，否则会报错
public class MybatisMapperScannerConfig {

    private String SQL_SESSION_FACTORY = "sqlSessionFactory";
    private Logger logger = LoggerFactory.getLogger(MybatisMapperScannerConfig.class);

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        logger.info("-----------------开始配置MapperScannerConfigurer--------------------");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(SQL_SESSION_FACTORY);
        mapperScannerConfigurer.setBasePackage("com.shenbaoyong.attendance.dao");
        logger.info("-----------------配置成功MapperScannerConfigurer--------------------");
        return mapperScannerConfigurer;
    }
}
