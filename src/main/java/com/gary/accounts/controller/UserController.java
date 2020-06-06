package com.gary.accounts.controller;

import com.gary.accounts.common.AccountsCodeEnum;
import com.gary.accounts.vo.LoginRequestVO;
import com.gary.accounts.vo.ModifyPwdRequest;
import com.gary.accounts.vo.RegisterRequestVO;
import com.gary.accounts.service.UserService;
import com.gary.accounts.vo.LoginResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 丶武僧
 */

@Api(value = "用户相关API")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户登录接口", notes = "用户使用手机和密码登录")
    @PostMapping("/login")
    public LoginResponseVO login(@RequestBody LoginRequestVO loginRequestVO){
        return userService.login(loginRequestVO.getEmail(), loginRequestVO.getPassword());
    }

    @ApiOperation(value = "用户登出接口", notes = "用户登出")
    @GetMapping("/logout")
    public Boolean logout(){
        return null;
    }

    @ApiOperation(value = "用户注册接口", notes = "用户注册个人信息")
    @PostMapping("/register")
    public Boolean logon(@Valid @RequestBody RegisterRequestVO registerRequestVO){
        return userService.register(registerRequestVO);
    }

    @ApiOperation(value = "更改用户密码", notes = "用户密码更改")
    @PutMapping("modifyPwd")
    public Boolean modifyPwd(@Valid @RequestBody ModifyPwdRequest modifyPwdRequest){
        return true;
    }

}
