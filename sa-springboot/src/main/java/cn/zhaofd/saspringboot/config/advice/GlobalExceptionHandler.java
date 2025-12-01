/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.saspringboot.config.advice;

import cn.dev33.satoken.exception.*;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局Controller异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 统一处理NotLoginException(未登录异常)
     *
     * @param e NotLoginException
     * @return SaResult
     */
    @ExceptionHandler(NotLoginException.class)
    public SaResult handlerNotLoginException(NotLoginException e) {
        /*
        // 判断场景值，定制化异常信息
        String message;
        if (e.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未能读取到有效token";
        } else if (e.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (e.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (e.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (e.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else if (e.getType().equals(NotLoginException.TOKEN_FREEZE)) {
            message = "token已被冻结";
        } else if (e.getType().equals(NotLoginException.NO_PREFIX)) {
            message = "未按照指定前缀提交token";
        } else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return SaResult.error(message);
        */

        return SaResult.error(e.getMessage());
    }

    /**
     * 统一处理NotPermissionException(缺少权限异常)
     *
     * @param e NotPermissionException
     * @return SaResult
     */
    @ExceptionHandler(NotPermissionException.class)
    public SaResult handlerException(NotPermissionException e) {
        return SaResult.error("缺少权限：" + e.getPermission());
    }

    /**
     * 统一处理NotRoleException(缺少角色异常)
     * @param e NotRoleException
     * @return SaResult
     */
    @ExceptionHandler(NotRoleException.class)
    public SaResult handlerException(NotRoleException e) {
        return SaResult.error("缺少角色：" + e.getRole());
    }

    /**
     * 统一处理NotSafeException(二级认证校验失败异常)
     * @param e NotSafeException
     * @return SaResult
     */
    @ExceptionHandler(NotSafeException.class)
    public SaResult handlerException(NotSafeException e) {
        return SaResult.error("二级认证校验失败：" + e.getService());
    }

    /**
     * 统一处理DisableServiceException(服务封禁异常)
     * @param e DisableServiceException
     * @return SaResult
     */
    @ExceptionHandler(DisableServiceException.class)
    public SaResult handlerException(DisableServiceException e) {
        return SaResult.error("当前账号 " + e.getService() + " 服务已被封禁 (level=" + e.getLevel() + ")：" + e.getDisableTime() + "秒后解封");
    }

    /**
     * 统一处理NotHttpBasicAuthException(Http Basic校验失败异常)
     *
     * @param e NotHttpBasicAuthException
     * @return SaResult
     */
    @ExceptionHandler(NotHttpBasicAuthException.class)
    public SaResult handlerException(NotHttpBasicAuthException e) {
        return SaResult.error(e.getMessage());
    }

    /**
     * 统一处理Exception(其它所有异常)
     *
     * @param e Exception
     * @return SaResult
     */
    @ExceptionHandler(Exception.class)
    public SaResult handlerException(Exception e) {
        return SaResult.error(e.getMessage());
    }
}
