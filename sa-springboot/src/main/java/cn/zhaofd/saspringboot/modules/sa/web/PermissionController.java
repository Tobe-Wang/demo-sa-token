/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.modules.sa.web;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限控制
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    /**
     * 获取权限列表
     *
     * @return 权限列表
     */
    @RequestMapping("/list")
    public List<String> getPermissionList() {
        return StpUtil.getPermissionList();
    }

    /**
     * 判断当前账号是否含有指定权限
     *
     * @param permission 权限码
     * @return 是否含有指定权限
     */
    @RequestMapping("/hasPermission")
    public Boolean hasPermission(@RequestParam("permission") String permission) {
        return StpUtil.hasPermission(permission);
    }

    /**
     * 校验当前账号是否含有指定权限
     *
     * @param permission 权限码
     */
    @RequestMapping("/checkPermission")
    public void checkPermission(@RequestParam("permission") String permission) {
        StpUtil.checkPermission(permission);
    }

    /**
     * 校验当前账号是否含有指定权限(可多个)
     */
    @RequestMapping("/checkPermissions")
    public void checkPermissions() {
//        // 校验：当前账号是否含有指定权限 [指定多个，必须全部验证通过]
//        StpUtil.checkPermissionAnd("user.add", "user.delete", "user.get");

        // 校验：当前账号是否含有指定权限 [指定多个，只要其一验证通过即可]
        StpUtil.checkPermissionOr("user.add", "user.delete", "user.get");
    }
}
