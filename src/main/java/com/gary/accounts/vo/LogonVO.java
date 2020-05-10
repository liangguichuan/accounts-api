package com.gary.accounts.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LogonVO implements Serializable {

    private static final long serialVersionUID = 2003129393729253476L;

    @NotBlank
    private String name;

    @NotBlank
    private String nickName;

    private String phone;

    @Email
    private String email;

    @NotBlank
    private String password;
}
