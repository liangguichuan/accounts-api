package com.chuan.accounts.service.impl;

import com.chuan.accounts.bean.dto.UserInfoDTO;
import com.chuan.accounts.manager.UserManager;
import com.chuan.accounts.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserInfoDTO findUserByNameAndPassword(String email, String password) {
        return userManager.findUserByNameAndPassword(email, password);
    }

}
