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
     *
     * @return String
     */
    @SaCheckPermission("user-add")
    public String modify() {
        return "用户更新";
    }
}
