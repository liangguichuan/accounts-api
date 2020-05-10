package com.gary.accounts.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 丶武僧
 * 业务异常，统一抛出http code 600
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    private final String msg;

    public BusinessException(String message) {
        super(message);
        this.msg = message;
    }
}
