package com.gary.accounts.interceptor;

import com.gary.accounts.common.AccountsCodeEnum;
import com.gary.accounts.common.AccountsException;
import com.gary.accounts.common.AccountsResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 丶武僧
 * 异常拦截，统一处理系统异常
 */

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public AccountsResult<Void> systemError(Exception e) {
        log.error(e.getMessage(), e);
        return AccountsResult.fail(AccountsCodeEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AccountsResult<Void> paramError(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return AccountsResult.fail(AccountsCodeEnum.PARAM_ERROR.getCode(),
                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(AccountsException.class)
    public AccountsResult<Void> businessError(AccountsException e){
        log.error(e.getMessage(), e);
        return AccountsResult.fail(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AccountsResult<Void> methodSupportError(HttpRequestMethodNotSupportedException e){
        log.error(e.getMethod(), e);
        return AccountsResult.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }

}
