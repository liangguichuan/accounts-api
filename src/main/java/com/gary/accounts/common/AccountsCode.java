package com.gary.accounts.common;

import java.util.Objects;

public enum AccountsCode {

    SUCCESS(200, "Success"),
    UNAUTHORIZED(401, "Unauthorized"),
    PARAM_ERROR(405, "Bad Request"),
    SYSTEM_ERROR(500, "Accounts System Error!");

    private final Integer code;

    private final String msg;

    AccountsCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static AccountsCode valueOf(Integer code){
        Objects.requireNonNull(code);
        for (AccountsCode accountsCode : AccountsCode.values()) {
            if(accountsCode.code.equals(code)){
                return accountsCode;
            }
        }
        throw new IllegalArgumentException("AccountsCode Not Found code: " + code);
    }
}
