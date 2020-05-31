package com.gary.accounts.controller;

import com.gary.accounts.vo.LoginVO;
import com.gary.accounts.vo.LogonVO;
import com.gary.accounts.service.UserService;
import com.gary.accounts.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

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
    public UserVO login(@RequestBody LoginVO loginVO){
        return userService.login(loginVO.getEmail(), loginVO.getPassword());
    }

    @ApiOperation(value = "用户登出接口", notes = "用户登出")
    @GetMapping("/logout")
    public Boolean logout(){
        return null;
    }

    @ApiOperation(value = "用户注册接口", notes = "用户注册个人信息")
    @PostMapping("/logon")
    public Boolean logon(@Valid @RequestBody LogonVO logonVO){
        return userService.logon(logonVO);
    }

    @ApiOperation(value = "更改用户密码", notes = "用户密码更改")
    @PutMapping("modifyPwd")
    public Boolean modifyPwd(){
        return true;
    }

    @GetMapping("/test")
    public String test(){
        String s = null;
        Objects.requireNonNull(s);
        return s;
    }

}
