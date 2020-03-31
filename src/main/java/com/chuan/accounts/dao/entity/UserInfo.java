package com.chuan.accounts.dao.entity;

import java.util.Date;

public class UserInfo {
    private Long id;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

    private String email;

    public UserInfo(Long id, String name, String password, Date createTime, Date updateTime, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.email = email;
    }

    public UserInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}