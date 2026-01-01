/*
 * Copyright (c) 2026. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saoauth2server;

import cn.dev33.satoken.oauth2.SaOAuth2Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaOauth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaOauth2ServerApplication.class, args);
        System.out.println("\nSa-Token-OAuth2 Server端启动成功，配置如下：");
        System.out.println(SaOAuth2Manager.getServerConfig());
    }
}
