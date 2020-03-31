package com.chuan.accounts.interceptor;

import com.chuan.accounts.bean.business.BusinessCode;
import com.chuan.accounts.bean.business.BusinessException;
import com.chuan.accounts.bean.business.BusinessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    public BusinessResult systemError(Exception e) {
        log.error(e.getMessage(), e);
        return BusinessResult.failed(BusinessCode.SYSTEM_ERROR, "System Error");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BusinessResult paramError(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return BusinessResult.failed(BusinessCode.INVALID_PARAM, e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public BusinessResult businessError(BusinessException e){
        log.error(e.getMessage(), e);
        return BusinessResult.failed(BusinessCode.BUSINESS_ERROR, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void methodSupportError(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

}
