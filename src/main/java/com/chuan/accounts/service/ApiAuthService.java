package com.chuan.accounts.service;

import com.chuan.accounts.bean.vo.AuthVO;
import com.chuan.accounts.bean.vo.LoginVO;

public interface ApiAuthService {

    AuthVO login(LoginVO loginVO);

}
