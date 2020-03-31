package com.chuan.accounts.controller;

import com.chuan.accounts.bean.business.BusinessResult;
import com.chuan.accounts.bean.vo.AuthVO;
import com.chuan.accounts.bean.vo.LoginVO;
import com.chuan.accounts.bean.vo.LogonVO;
import com.chuan.accounts.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public BusinessResult<AuthVO> login(@RequestBody LoginVO loginVO){
        return BusinessResult.success(authService.login(loginVO));
    }

    @DeleteMapping("/logout")
    public void logout(){

    }

    @PostMapping("/logon")
    public boolean logon(@RequestBody LogonVO logonVO){
        return false;
    }
}
