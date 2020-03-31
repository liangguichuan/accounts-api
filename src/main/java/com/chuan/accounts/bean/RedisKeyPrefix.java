package com.chuan.accounts.bean;

public enum RedisKeyPrefix {
    USERINFO("Accounts", "User_id", "Token"),
    OVERVIEW("Overview", "View_id", "List");

    private final String project;

    private final String type;

    private final String data;

    RedisKeyPrefix(String project, String type, String data) {
        this.project = project;
        this.type = type;
        this.data = data;
    }

    public String generateKey(Long id) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.project).append(":").append(this.type).append(":")
                .append(id).append(":").append(this.data);
        return builder.toString();
    }
}
