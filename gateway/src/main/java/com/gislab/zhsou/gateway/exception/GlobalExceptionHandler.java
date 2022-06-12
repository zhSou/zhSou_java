package com.gislab.zhsou.gateway.exception;

import com.gislab.zhsou.common.exception.AppException;
import com.gislab.zhsou.gateway.common.ResponseMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseMessage defaultException(HttpServletRequest request, Exception e) {
        return ResponseMessage.invokeFail(e.getMessage());
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseMessage appException(HttpServletRequest request, Exception e) {
        AppException appException = (AppException) e;
        return ResponseMessage.invokeFail(appException.getInfo());
    }
}
