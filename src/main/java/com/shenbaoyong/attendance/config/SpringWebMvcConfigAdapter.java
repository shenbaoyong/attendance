package com.shenbaoyong.attendance.config;

import com.shenbaoyong.attendance.interceptor.AuthenticationIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@Configuration
public class SpringWebMvcConfigAdapter extends WebMvcConfigurerAdapter{

    @Autowired
    AuthenticationIntercepter authenticationIntercepter;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationIntercepter)
                .addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/test/**")
                .excludePathPatterns("/account/login");
    }
}
