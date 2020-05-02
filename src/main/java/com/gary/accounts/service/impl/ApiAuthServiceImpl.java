package com.gary.accounts.service.impl;

import com.gary.accounts.bean.business.BusinessException;
import com.gary.accounts.bean.dto.UserInfoDTO;
import com.gary.accounts.bean.vo.AuthVO;
import com.gary.accounts.bean.vo.LoginVO;
import com.gary.accounts.manager.ApiAuthManager;
import com.gary.accounts.service.ApiAuthService;
import com.gary.accounts.service.UserService;
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
