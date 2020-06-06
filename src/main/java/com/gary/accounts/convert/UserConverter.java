package com.gary.accounts.convert;

import com.gary.accounts.entity.User;
import com.gary.accounts.vo.RegisterRequestVO;
import com.gary.accounts.vo.LoginResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;

import java.util.Objects;

/**
 * @author 丶武僧
 */
public class UserConverter {

    private UserConverter(){}

    public static LoginResponseVO convert(User user){
        if(Objects.isNull(user)){
            return null;
        }
        LoginResponseVO vo = new LoginResponseVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    public static User convert(RegisterRequestVO registerRequestVO){
        if(Objects.isNull(registerRequestVO)){
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(registerRequestVO, user);
        String salt = user.getEmail() + user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(salt.getBytes()));
        return user;
    }
}
