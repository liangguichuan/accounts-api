package com.gary.accounts.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 丶武僧
 * 业务异常，统一抛出http code 600
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccountsException extends RuntimeException {

    private final AccountsCode accountsCode;

    public AccountsException(AccountsCode accountsCode) {
        super(accountsCode.getMsg());
        this.accountsCode = accountsCode;
    }
}
