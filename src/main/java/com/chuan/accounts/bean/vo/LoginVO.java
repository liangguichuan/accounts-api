package com.chuan.accounts.bean.vo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVO {

    @NotBlank(message = "用户姓名不能为空!")
    private String name;

    @NotBlank(message = "请输入密码!")
    private String password;
}
