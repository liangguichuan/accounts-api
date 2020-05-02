package com.gary.accounts.service.impl;

import com.gary.accounts.bean.dto.UserInfoDTO;
import com.gary.accounts.manager.UserManager;
import com.gary.accounts.service.UserService;
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
