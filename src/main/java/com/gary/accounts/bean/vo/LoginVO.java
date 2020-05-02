package com.gary.accounts.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVO {

    @NotBlank(message = "邮箱不能为空!")
    private String email;

    @NotBlank(message = "请输入密码!")
    private String password;
}
