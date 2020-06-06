package com.gary.accounts.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ModifyPwdRequest {

    @NotBlank(message = "Verification code can't be empty!")
    private String code;

    @NotBlank(message = "New password can't be empty!")
    private String newPassword;

    @NotBlank(message = "Old password can't be empty!")
    private String oldPassword;

}
