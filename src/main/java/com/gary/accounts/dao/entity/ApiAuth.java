package com.gary.accounts.dao.entity;

import java.util.Date;

public class ApiAuth {
    private Integer userId;

    private String apiKey;

    private String token;

    private Date updateTime;

    public ApiAuth(Integer userId, String apiKey, String token, Date updateTime) {
        this.userId = userId;
        this.apiKey = apiKey;
        this.token = token;
        this.updateTime = updateTime;
    }

    public ApiAuth() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey == null ? null : apiKey.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}