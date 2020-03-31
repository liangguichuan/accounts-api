package com.chuan.accounts.bean.business;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private final String msg;

    public BusinessException(String message) {
        super(message);
        this.msg = message;
    }
}
