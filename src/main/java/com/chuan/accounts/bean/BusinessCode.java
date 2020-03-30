package com.chuan.accounts.bean;

public enum BusinessCode {

    SUCCESS(2000L),
    INVALID_PARAM(3000L),
    BUSINESS_ERROR(4000L),
    SYSTEM_ERROR(5000L);

    private final Long code;

    BusinessCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
