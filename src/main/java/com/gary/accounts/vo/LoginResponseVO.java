package com.gary.accounts.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponseVO implements Serializable {

    private Long id;

    private String name;

    private String nickName;

}
