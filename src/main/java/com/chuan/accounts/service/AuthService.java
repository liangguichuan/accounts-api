package com.chuan.accounts.service;

import com.chuan.accounts.bean.vo.AuthVO;
import com.chuan.accounts.bean.vo.LoginVO;

public interface AuthService {

    AuthVO login(LoginVO loginVO);
}
