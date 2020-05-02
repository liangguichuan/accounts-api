package com.gary.accounts.interceptor;

import com.gary.accounts.bean.business.BusinessException;
import com.gary.accounts.bean.business.BusinessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 丶武僧
 * 异常拦截，统一处理系统异常
 */

@RestControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    private static final int BUSINESS_CODE = 600;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public BusinessResult systemError(Exception e, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        return BusinessResult.failed(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BusinessResult paramError(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return BusinessResult.failed(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public BusinessResult businessError(BusinessException e, HttpServletResponse response){
        log.error(e.getMessage(), e);
        response.setStatus(BUSINESS_CODE);
        return BusinessResult.failed(e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    public BusinessResult methodSupportError(HttpRequestMethodNotSupportedException e){
        log.error(e.getMethod(), e);
        return BusinessResult.failed(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }

}
