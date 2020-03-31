package com.chuan.accounts.service;

import com.chuan.accounts.bean.dto.UserInfoDTO;

public interface UserService {

   UserInfoDTO findUserByNameAndPassword(String email, String password);
}
