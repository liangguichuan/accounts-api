package com.chuan.accounts.bean.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthVO implements Serializable {

    private Long userId;

    private String token;

}
