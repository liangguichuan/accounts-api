package com.gary.accounts.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountsCodeEnum implements AccountsExceptionAssert {

    SUCCESS(200, "Success!"),
    UNAUTHORIZED(401, "Unauthorized!"),
    PARAM_ERROR(405, "Bad Request!"),
    SYSTEM_ERROR(500, "Accounts System Error!"),
    BUSINESS_ERROR(600, "Accounts Business Error!"),

    //用户相关错误
    LOGIN_ERROR(601, "User email or password incorrect!"),
    STATUS_ERROR(602, "Account is disabled!"),
    REGISTER_ERROR(603, "Email or phone number registered!"),
    MODIFY_PASSWORD_ERROR(604, "Failed to modify password!");

    private final Integer code;

    private final String msg;

}
