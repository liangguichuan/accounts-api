package com.gary.accounts.controller;

import com.gary.accounts.bean.business.BusinessResult;
import com.gary.accounts.bean.vo.AuthVO;
import com.gary.accounts.bean.vo.LoginVO;
import com.gary.accounts.bean.vo.LogonVO;
import com.gary.accounts.service.ApiAuthService;
import org.springframework.web.bind.annotation.*;

/**
 * @author 丶武僧
 */
@RestController
@RequestMapping("/auth")
public class ApiAuthController {

    private ApiAuthService apiAuthService;

    public ApiAuthController(ApiAuthService apiAuthService) {
        this.apiAuthService = apiAuthService;
    }

    @PostMapping("/login")
    public BusinessResult<AuthVO> login(@RequestBody LoginVO loginVO){
        return BusinessResult.success(apiAuthService.login(loginVO));
    }

    @DeleteMapping("/logout")
    public void logout(){

    }

    @PostMapping("/logon")
    public boolean logon(@RequestBody LogonVO logonVO){
        return false;
    }
}
