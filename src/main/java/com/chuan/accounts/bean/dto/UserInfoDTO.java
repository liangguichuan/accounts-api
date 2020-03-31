package com.chuan.accounts.bean.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDTO {

    private Long id;

    private String name;

    private String nickName;

    private Date createTime;

    private Date updateTime;
}
