/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel3backendclient.modules.sso.web.h5;

import cn.dev33.satoken.fun.strategy.SaCorsHandleFunction;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证]配置类
 */
@Configuration
public class SaTokenConfigure {
    /**
     * CORS跨域处理策略
     */
    @Bean
    public SaCorsHandleFunction corsHandle() {
        return (req, res, sto) -> {
            res.setHeader("Access-Control-Allow-Origin", "*") // 允许指定域访问跨域资源
                    .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE") // 允许所有请求方式
                    .setHeader("Access-Control-Max-Age", "3600") // 有效时间
                    .setHeader("Access-Control-Allow-Headers", "*"); // 允许的header参数

            // 如果是预检请求，则立即返回到前端
            SaRouter.match(SaHttpMethod.OPTIONS).free(r -> System.out.println("--------OPTIONS预检请求，不做处理")).back();
        };
    }
}
