package com.chuan.accounts.bean.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AuthVO implements Serializable {

    private Long userId;

    private String token;

}
