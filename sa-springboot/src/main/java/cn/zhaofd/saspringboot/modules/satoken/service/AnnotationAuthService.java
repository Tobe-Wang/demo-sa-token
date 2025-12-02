/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.modules.satoken.service;

import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.stereotype.Service;

@Service
public class AnnotationAuthService {
    /**
     * 用户更新
     * <br />默认拦截器模式有一个缺点无法在Controller层以外的代码使用进行校验，使用AOP插件便可以在任意层级使用注解鉴权
     *
     * @return String
     */
    @SaCheckPermission("user-add")
    public String modify() {
        return "用户更新";
    }
}
