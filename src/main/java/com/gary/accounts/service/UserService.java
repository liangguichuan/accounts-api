package com.gary.accounts.service;

import com.gary.accounts.bean.dto.UserInfoDTO;

public interface UserService {

   UserInfoDTO findUserByNameAndPassword(String email, String password);
}
