/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel2client.modules.sso.web;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.sso.processor.SaSsoClientProcessor;
import cn.dev33.satoken.sso.template.SaSsoClientTemplate;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token SSO-Client端 Controller
 */
@RestController
public class SsoClientController {
    /**
     * 首页
     *
     * @return String
     */
    @RequestMapping("/")
    public String index() {
        // @formatter:off
        return "<h2>Sa-Token SSO-Client 应用端 (模式二)</h2>" +
                "<p>当前会话是否登录：" + StpUtil.isLogin() + " (" + StpUtil.getLoginId("") + ")</p>" +
                "<p> " +
                "<a href='/sso/login?back=/'>登录</a> - " +
                "<a href='/sso/logoutByAlone?back=/'>单应用注销</a> - " +
                "<a href='/sso/logout?back=self'>全端注销</a> - " +
                "<a href='/sso/myInfo' target='_blank'>账号资料</a>" +
                "</p>";
        // @formatter:on
    }

    /**
     * SSO-Client端：处理所有SSO相关请求
     * http://{host}:{port}/sso/login   Client端登录地址
     * http://{host}:{port}/sso/logout  Client端注销地址（isSlo=true时打开）
     * http://{host}:{port}/sso/pushC   Client端接收消息推送地址
     *
     * @return Object
     */
    @RequestMapping("/sso/*")
    public Object ssoRequest() {
        return SaSsoClientProcessor.instance.dister();
    }

    /**
     * 配置SSO相关参数
     *
     * @param ssoClientTemplate 模板
     */
    @Autowired
    private void configSso(SaSsoClientTemplate ssoClientTemplate) {
    }

    /**
     * 当前应用独自注销 (不退出其它应用)
     *
     * @return Object
     */
    @RequestMapping("/sso/logoutByAlone")
    public Object logoutByAlone() {
        StpUtil.logout();
        return SaSsoClientProcessor.instance._ssoLogoutBack(SaHolder.getRequest(), SaHolder.getResponse());
    }
}
