/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMvc配置
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    /**
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册Sa-Token拦截器，打开注解式鉴权功能
//        // 默认拦截器模式有一个缺点无法在Controller层以外的代码使用进行校验，使用AOP插件便可以在任意层级使用注解鉴权
//        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
