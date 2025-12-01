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
 * 角色控制
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    @RequestMapping("/list")
    public List<String> getRoleList() {
        return StpUtil.getRoleList();
    }

    /**
     * 判断当前账号是否含有指定角色
     *
     * @param role 角色码
     * @return 是否含有指定角色
     */
    @RequestMapping("/hasRole")
    public Boolean hasRole(@RequestParam("role") String role) {
        return StpUtil.hasRole(role);
    }

    /**
     * 校验当前账号是否含有指定角色
     *
     * @param role 角色码
     */
    @RequestMapping("/checkRole")
    public void checkRole(@RequestParam("role") String role) {
        StpUtil.checkRole(role);
    }

    /**
     * 校验当前账号是否含有指定角色(可多个)
     */
    @RequestMapping("/checkRoles")
    public void checkRoles() {
//        // 校验：当前账号是否含有指定角色标识 [指定多个，必须全部验证通过]
//        StpUtil.checkRoleAnd("super-admin", "shop-admin");

        // 校验：当前账号是否含有指定角色标识 [指定多个，只要其一验证通过即可]
        StpUtil.checkRoleOr("super-admin", "shop-admin");
    }
}
