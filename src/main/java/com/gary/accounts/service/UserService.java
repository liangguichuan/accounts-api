package com.gary.accounts.service;

import com.gary.accounts.vo.RegisterRequestVO;
import com.gary.accounts.vo.LoginResponseVO;

public interface UserService {

   LoginResponseVO login(String email, String password);

   Boolean register(RegisterRequestVO registerRequestVO);

   Boolean modifyPwd(String code, String oldPassword, String newPassword);

}
