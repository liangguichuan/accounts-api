package com.gary.accounts.service;

import com.gary.accounts.bean.vo.AuthVO;
import com.gary.accounts.bean.vo.LoginVO;

public interface ApiAuthService {

    AuthVO login(LoginVO loginVO);

}
