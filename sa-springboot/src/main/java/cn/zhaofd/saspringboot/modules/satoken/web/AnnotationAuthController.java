/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.modules.satoken.web;

import cn.dev33.satoken.annotation.SaCheckDisable;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解鉴权控制
 */
@RestController
@RequestMapping("/annotation/auth")
public class AnnotationAuthController {
    /**
     * 登录校验：只有登录之后才能进入该方法
     *
     * @return String
     */
    @SaCheckLogin
    @RequestMapping("/info")
    public String info() {
        return "查询用户信息";
    }

    /**
     * 角色校验：必须具有指定角色才能进入该方法
     *
     * @return String
     */
    @SaCheckRole("super-admin")
    @RequestMapping("/role/add")
    public String addByRole() {
        return "用户增加";
    }

    /**
     * 权限校验：必须具有指定权限才能进入该方法
     *
     * @return String
     */
    @SaCheckPermission("user-add")
    @RequestMapping("/permission/add")
    public String addByPermission() {
        return "用户增加";
    }

    /**
     * 禁用校验：当前账号是否被封禁 comment 服务，如果已被封禁会抛出异常，无法进入方法
     *
     * @return String
     */
    @SaCheckDisable("comment")
    @RequestMapping("/send")
    public String send() {
        return "账号未被封禁";
    }
}
