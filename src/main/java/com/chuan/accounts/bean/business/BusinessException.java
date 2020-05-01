package com.chuan.accounts.bean.business;

import lombok.Data;

/**
 * @author 丶武僧
 * 业务异常，统一抛出http code 600
 */

@Data
public class BusinessException extends RuntimeException {

    private final String msg;

    public BusinessException(String message) {
        super(message);
        this.msg = message;
    }
}
