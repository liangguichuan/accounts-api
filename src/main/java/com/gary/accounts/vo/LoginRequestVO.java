package com.gary.accounts.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestVO {

    @Email(message = "邮箱格式不正确!")
    private String email;

    @NotBlank(message = "密码不能为空!")
    private String password;

}
