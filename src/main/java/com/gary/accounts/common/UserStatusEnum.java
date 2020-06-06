package com.gary.accounts.common;

public enum UserStatusEnum {

    //禁用
    DISABLED((byte) -1),
    //锁定
    LOCK((byte)0),
    //启用
    ENABLED((byte) 1);

    private final byte value;

    UserStatusEnum(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public static UserStatusEnum valueOf(byte value) {
        for (UserStatusEnum status : UserStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("UserStatus Not Found Value: " + value);
    }
}
