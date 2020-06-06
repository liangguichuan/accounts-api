package com.gary.accounts.common;

public interface AccountsExceptionAssert extends AssertAccounts {

    Integer getCode();

    String getMsg();

    @Override
    default AccountsException newException(){
        return new AccountsException(this);
    }
}
