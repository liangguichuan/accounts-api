package com.gary.accounts.common;

public enum RedisKeyPrefix {
    USERINFO("Accounts", "User_id", "Token"),
    OVERVIEW("Overview", "View_id", "List"),
    TONGJI("Schedule", "name", "test");

    private final String project;

    private final String type;

    private final String data;

    RedisKeyPrefix(String project, String type, String data) {
        this.project = project;
        this.type = type;
        this.data = data;
    }

    public String generateKey(Long id) {
        return this.project + ":" + this.type + ":" + id + ":" + this.data;
    }
}
