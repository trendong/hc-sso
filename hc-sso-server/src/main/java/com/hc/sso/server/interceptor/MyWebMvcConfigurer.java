package com.hc.sso.server.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/11
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private PermissionInterceptor permissionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(permissionInterceptor).addPathPatterns("/**");
    }

}
