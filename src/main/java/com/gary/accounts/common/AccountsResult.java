package com.gary.accounts.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 丶武僧
 * 返回数据统一包装
 */

@Data
@AllArgsConstructor
public class AccountsResult<T> implements Serializable {

    private static final long serialVersionUID = -5209390822512234334L;

    private Integer code;

    private String msg;

    private T data;

    public static <T> AccountsResult<T> success(T data){
        return new AccountsResult<>(AccountsCodeEnum.SUCCESS.getCode(), AccountsCodeEnum.SUCCESS.getMsg(), data);
    }

    public static AccountsResult<Void> fail(AccountsCodeEnum accountsCodeEnum){
        return fail(accountsCodeEnum.getCode(), accountsCodeEnum.getMsg());
    }

    public static AccountsResult<Void> fail(Integer code, String msg){
        return new AccountsResult<>(code, msg, null);
    }

}
