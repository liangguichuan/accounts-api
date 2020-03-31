package com.chuan.accounts.service.impl;

import com.chuan.accounts.bean.vo.AuthVO;
import com.chuan.accounts.bean.vo.LoginVO;
import com.chuan.accounts.service.AuthService;
import com.chuan.accounts.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthVO login(LoginVO loginVO) {
        //TODO 校验用户是否存在
        String token = JwtUtil.createToken(1L, "12345");
        return AuthVO.builder().userId(1L).token(token).build();
    }
}
