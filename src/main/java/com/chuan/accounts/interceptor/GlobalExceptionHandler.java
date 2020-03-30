package com.chuan.accounts.interceptor;

import com.chuan.accounts.bean.BusinessCode;
import com.chuan.accounts.bean.BusinessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

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

}
