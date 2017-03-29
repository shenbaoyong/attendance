package com.shenbaoyong.attendance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Baoyong Shen on 2017/3/15.
 * spring-session
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600*3)
public class HttpSessionConfig {
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
