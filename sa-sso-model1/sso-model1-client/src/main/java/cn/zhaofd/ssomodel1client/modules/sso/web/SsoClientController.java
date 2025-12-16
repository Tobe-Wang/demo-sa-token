/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel1client.modules.sso.web;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.sso.SaSsoManager;
import cn.dev33.satoken.sso.config.SaSsoClientConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token SSO-Client端 Controller
 */
@RestController
public class SsoClientController {
    /**
     * SSO-Client端：首页
     *
     * @param request 请求
     * @return 结果
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String url = SaFoxUtil.encodeUrl(SaFoxUtil.joinParam(SaHolder.getRequest().getUrl(), request.getQueryString()));
        SaSsoClientConfig cfg = SaSsoManager.getClientConfig();

        // @formatter:off
        return "<h2>Sa-Token SSO-Client 应用端 (模式一)</h2>"
                + "<p>当前会话是否登录：" + StpUtil.isLogin() + " (" + StpUtil.getLoginId("") + ")</p>"
                + "<p>"
                    + "<a href='" + cfg.splicingAuthUrl() + "?mode=simple&client=" + cfg.getClient() + "&redirect=" + url + "'>登录</a> - "
                    + "<a href='" + cfg.splicingSignoutUrl() + "?back=" + url + "'>注销</a>"
                + "</p>";
        // @formatter:on
    }
}
