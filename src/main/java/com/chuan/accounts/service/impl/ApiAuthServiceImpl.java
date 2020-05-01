package com.chuan.accounts.service.impl;

import com.chuan.accounts.bean.business.BusinessException;
import com.chuan.accounts.bean.dto.UserInfoDTO;
import com.chuan.accounts.bean.vo.AuthVO;
import com.chuan.accounts.bean.vo.LoginVO;
import com.chuan.accounts.manager.ApiAuthManager;
import com.chuan.accounts.service.ApiAuthService;
import com.chuan.accounts.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ApiAuthServiceImpl implements ApiAuthService {

    private UserService userService;

    private ApiAuthManager apiAuthManager;

    public ApiAuthServiceImpl(UserService userService, ApiAuthManager apiAuthManager) {
        this.userService = userService;
        this.apiAuthManager = apiAuthManager;
    }

    @Override
    public AuthVO login(LoginVO loginVO) {
        UserInfoDTO userInfoDTO = userService.findUserByNameAndPassword(loginVO.getEmail(), loginVO.getPassword());
        if(Objects.isNull(userInfoDTO)){
            throw new BusinessException("用户名或密码错误");
        }

        return AuthVO.builder().userId(userInfoDTO.getId()).token("123456").build();
    }
}
