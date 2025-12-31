/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel3backendclient.modules.sso.web.h5;

import cn.dev33.satoken.sso.model.SaCheckTicketResult;
import cn.dev33.satoken.sso.processor.SaSsoClientProcessor;
import cn.dev33.satoken.sso.template.SaSsoClientUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.parameter.SaLoginParameter;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前后台分离架构下集成SSO
 * <br />注：如果不需要前后端分离架构下集成SSO，可删除此包下所有代码
 */
@RestController
public class H5Controller {
    /**
     * 当前是否登录
     *
     * @return SaResult
     */
    @RequestMapping("/sso/isLogin")
    public Object isLogin() {
        return SaResult.data(StpUtil.isLogin()).set("loginId", StpUtil.getLoginIdDefaultNull());
    }

    /**
     * 返回SSO认证中心登录地址
     *
     * @param clientLoginUrl 客户端登录地址
     * @return SaResult
     */
    @RequestMapping("/sso/getSsoAuthUrl")
    public SaResult getSsoAuthUrl(String clientLoginUrl) {
        String serverAuthUrl = SaSsoClientUtil.buildServerAuthUrl(clientLoginUrl, "");
        return SaResult.data(serverAuthUrl);
    }

    /**
     * 根据ticket进行登录
     *
     * @param ticket 票据
     * @return SaResult
     */
    @RequestMapping("/sso/doLoginByTicket")
    public SaResult doLoginByTicket(String ticket) {
        SaCheckTicketResult ctr = SaSsoClientProcessor.instance.checkTicket(ticket, "/sso/doLoginByTicket");
        StpUtil.login(ctr.loginId, new SaLoginParameter().setTimeout(ctr.remainTokenTimeout).setDeviceId(ctr.deviceId));
        return SaResult.data(StpUtil.getTokenValue());
    }
}