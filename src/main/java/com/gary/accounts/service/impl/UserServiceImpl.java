package com.gary.accounts.service.impl;

import com.gary.accounts.common.AccountsCodeEnum;
import com.gary.accounts.common.AccountsException;
import com.gary.accounts.common.UserStatusEnum;
import com.gary.accounts.convert.UserConverter;
import com.gary.accounts.entity.User;
import com.gary.accounts.manager.UserManager;
import com.gary.accounts.service.UserService;
import com.gary.accounts.vo.RegisterRequestVO;
import com.gary.accounts.vo.LoginResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * 用户登录
     * @param email 用户邮箱
     * @param password 用户密码
     * @return 用户基本信息
     */
    @Override
    public LoginResponseVO login(String email, String password) {
        String salt = email + password;
        password = DigestUtils.md5DigestAsHex(salt.getBytes());
        User user = userManager.findUserByNameAndPassword(email, password);
        AccountsCodeEnum.LOGIN_ERROR.assertNotNull(user);
        AccountsCodeEnum.STATUS_ERROR.assertEquals(UserStatusEnum.ENABLED, UserStatusEnum.valueOf(user.getStatus()));
        return UserConverter.convert(user);
    }

    /**
     * 用户注册
     * @param registerRequestVO 用户注册信息
     * @return 是否注册成功
     */
    @Override
    public Boolean register(RegisterRequestVO registerRequestVO) {
        List<User> registerUsers = userManager.findUserByEmailOrPhone(registerRequestVO.getEmail(), registerRequestVO.getPhone());
        AccountsCodeEnum.REGISTER_ERROR.assertListEmpty(registerUsers);
        String salt = registerRequestVO.getEmail() + registerRequestVO.getPassword();
        registerRequestVO.setPassword(DigestUtils.md5DigestAsHex(salt.getBytes()));
        User user = UserConverter.convert(registerRequestVO);
        return userManager.insertUser(user);
    }

    /**
     * 用户修改密码
     * @param code 验证码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    @Override
    public Boolean modifyPwd(String code, String oldPassword, String newPassword) {
        //TODO 校验code

        newPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        boolean result = userManager.updatePassword(oldPassword, newPassword);
        if(!result){
            throw new AccountsException(AccountsCodeEnum.MODIFY_PASSWORD_ERROR);
        }
        return null;
    }
}
