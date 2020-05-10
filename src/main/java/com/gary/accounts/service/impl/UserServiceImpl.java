package com.gary.accounts.service.impl;

import com.gary.accounts.convert.UserConverter;
import com.gary.accounts.entity.User;
import com.gary.accounts.manager.UserManager;
import com.gary.accounts.service.UserService;
import com.gary.accounts.vo.LogonVO;
import com.gary.accounts.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements UserService {

    private final UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserVO login(String email, String password) {
        String salt = email + password;
        password = DigestUtils.md5DigestAsHex(salt.getBytes());
        User user = userManager.findUserByNameAndPassword(email, password);
        return UserConverter.convert(user);
    }

    @Override
    public Boolean logon(LogonVO logonVO) {
        return userManager.insertUser(UserConverter.convert(logonVO));
    }
}
