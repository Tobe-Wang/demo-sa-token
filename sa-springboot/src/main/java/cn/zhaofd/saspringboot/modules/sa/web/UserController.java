/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.modules.sa.web;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户登录、登出控制
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @RequestMapping("/doLogin")
    public SaResult doLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    /**
     * 获取登录状态
     *
     * @return 登录状态
     */
    @RequestMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    /**
     * 检验登录
     */
    @RequestMapping("/checkLogin")
    public void checkLogin() {
        StpUtil.checkLogin();
    }

    /**
     * 获取当前登录id
     *
     * @return 登录id
     */
    @RequestMapping("/getLoginId")
    public String getLoginId() {
        /*
        // 获取当前会话账号id, 如果未登录，则抛出异常：`NotLoginException`
        StpUtil.getLoginId();

        // 类似查询API还有：
        StpUtil.getLoginIdAsString();    // 获取当前会话账号id, 并转化为`String`类型
        StpUtil.getLoginIdAsInt();       // 获取当前会话账号id, 并转化为`int`类型
        StpUtil.getLoginIdAsLong();      // 获取当前会话账号id, 并转化为`long`类型

        // 获取当前会话账号id, 如果未登录，则返回 null
        StpUtil.getLoginIdDefaultNull();

        // 获取当前会话账号id, 如果未登录，则返回默认值 （`defaultValue`可以为任意类型）
        StpUtil.getLoginId(T defaultValue);
        */

        return StpUtil.getLoginIdAsString();
    }

    /**
     * 获取 Token 信息
     *
     * @return SaResult
     */
    @RequestMapping("/tokenInfo")
    public SaResult tokenInfo() {
        /*
        // 获取当前会话的 token 值
        StpUtil.getTokenValue();

        // 获取当前`StpLogic`的 token 名称
        StpUtil.getTokenName();

        // 获取指定 token 对应的账号id，如果未登录，则返回 null
        StpUtil.getLoginIdByToken(String tokenValue);

        // 获取当前会话剩余有效期（单位：s，返回-1代表永久有效）
        StpUtil.getTokenTimeout();
        */

        return SaResult.data(StpUtil.getTokenInfo());
    }

    /**
     * 登出
     *
     * @return SaResult
     */
    @RequestMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    /**
     * 获取当前登录用户的角色和权限
     *
     * @return SaResult
     */
    @RequestMapping("/getRoleAndPermission")
    public SaResult getRoleAndPermission() {
        // 查询权限信息 ，如果当前会话未登录，会返回一个空集合
        List<String> permissionList = StpUtil.getPermissionList();

        // 查询角色信息 ，如果当前会话未登录，会返回一个空集合
        List<String> roleList = StpUtil.getRoleList();

        // 返回给前端
        return SaResult.ok()
                .set("roleList", roleList)
                .set("permissionList", permissionList);
    }
}
