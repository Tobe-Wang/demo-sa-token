/*
 * Copyright (c) 2025. Tobe Wang
 * Email：hzbeq@qq.com
 */

package cn.zhaofd.ssomodel2client.config.advice;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常拦截
     *
     * @param e Exception
     * @return SaResult
     */
    @ExceptionHandler(Exception.class)
    public SaResult handlerException(Exception e) {
        return SaResult.error(e.getMessage());
    }
}
