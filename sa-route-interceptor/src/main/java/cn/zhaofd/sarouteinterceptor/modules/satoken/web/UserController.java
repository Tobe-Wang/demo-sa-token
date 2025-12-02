/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.sarouteinterceptor.modules.satoken.web;

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
     * @return SaResult
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
     * @return SaResult
     */
    @RequestMapping("/isLogin")
    public SaResult isLogin() {
        boolean isLogin = StpUtil.isLogin();
        return SaResult.ok("当前客户端是否登录：" + isLogin);
    }

    /**
     * 检验登录
     */
    @RequestMapping("/checkLogin")
    public SaResult checkLogin() {
        // 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
        StpUtil.checkLogin();

        // 抛出异常后，代码将走入全局异常处理（GlobalException.java），如果没有抛出异常，则代表通过了登录校验，返回下面信息
        return SaResult.ok("校验登录成功，这行字符串是只有登录后才会返回的信息");
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

        /*
        // TokenInfo 包含了此 Token 的大多数信息
        SaTokenInfo info = StpUtil.getTokenInfo();
        System.out.println("Token 名称：" + info.getTokenName());
        System.out.println("Token 值：" + info.getTokenValue());
        System.out.println("当前是否登录：" + info.getIsLogin());
        System.out.println("当前登录的账号id：" + info.getLoginId());
        System.out.println("当前登录账号的类型：" + info.getLoginType());
        System.out.println("当前登录客户端的设备类型：" + info.getLoginDeviceType());
        System.out.println("当前 Token 的剩余有效期：" + info.getTokenTimeout()); // 单位：秒，-1代表永久有效，-2代表值不存在
        System.out.println("当前 Token 距离被冻结还剩：" + info.getTokenActiveTimeout()); // 单位：秒，-1代表永久有效，-2代表值不存在
        System.out.println("当前 Account-Session 的剩余有效期" + info.getSessionTimeout()); // 单位：秒，-1代表永久有效，-2代表值不存在
        System.out.println("当前 Token-Session 的剩余有效期" + info.getTokenSessionTimeout()); // 单位：秒，-1代表永久有效，-2代表值不存在
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
        return SaResult.ok("退出登录成功");
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
