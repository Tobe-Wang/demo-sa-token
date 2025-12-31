/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel3backendserver.modules.sso.web.h5;

import cn.dev33.satoken.sso.template.SaSsoServerUtil;
import cn.dev33.satoken.sso.util.SaSsoConsts;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前后台分离架构下集成SSO所需的代码 （SSO-Server端）
 * <br />注：如果不需要前后端分离架构下集成SSO，可删除此包下所有代码 *
 */
@RestController
public class H5Controller {
    /**
     * 返回当前是否已经登录
     *
     * @return SaResult
     */
    @RequestMapping("/sso/isLogin")
    public SaResult isLogin() {
        return SaResult.data(StpUtil.isLogin());
    }

    /**
     * 获取 redirectUrl
     *
     * @param client
     * @param redirect
     * @param mode 模式
     * @return SaResult
     */
    @RequestMapping("/sso/getRedirectUrl")
    public SaResult getRedirectUrl(String client, String redirect, String mode) {
        // 未登录情况下，返回 code=401
        if (!StpUtil.isLogin()) {
            return SaResult.code(401);
        }
        // 已登录情况下，构建 redirectUrl
        redirect = SaFoxUtil.decoderUrl(redirect);
        if (SaSsoConsts.MODE_SIMPLE.equals(mode)) {
            // 模式一
            SaSsoServerUtil.checkRedirectUrl(client, redirect);
            return SaResult.data(redirect);
        } else {
            // 模式二或模式三
            String redirectUrl = SaSsoServerUtil.buildRedirectUrl(client, redirect, StpUtil.getLoginId(), StpUtil.getTokenValue());
            return SaResult.data(redirectUrl);
        }
    }

}
