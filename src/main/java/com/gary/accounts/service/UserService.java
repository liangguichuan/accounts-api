package com.gary.accounts.service;

import com.gary.accounts.vo.LogonVO;
import com.gary.accounts.vo.UserVO;

public interface UserService {

   UserVO login(String email, String password);

   Boolean logon(LogonVO logonVO);

}
