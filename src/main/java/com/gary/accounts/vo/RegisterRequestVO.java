package com.gary.accounts.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterRequestVO implements Serializable {

    private static final long serialVersionUID = 2003129393729253476L;

    @NotBlank(message = "用户名不能为空!")
    private String name;

    @NotBlank(message = "用户昵称不能为空!")
    private String nickName;

    @NotBlank(message = "手机号不能为空!")
    private String phone;

    @Email(message = "邮箱格式不正确!")
    private String email;

    @NotBlank(message = "密码不能为空!")
    private String password;
}
