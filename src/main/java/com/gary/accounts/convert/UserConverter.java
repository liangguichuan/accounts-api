package com.gary.accounts.convert;

import com.gary.accounts.entity.User;
import com.gary.accounts.vo.LogonVO;
import com.gary.accounts.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;

import java.util.Objects;

/**
 * @author 丶武僧
 */
public class UserConverter {

    private UserConverter(){}

    public static UserVO convert(User user){
        if(Objects.isNull(user)){
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    public static User convert(LogonVO logonVO){
        if(Objects.isNull(logonVO)){
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(logonVO, user);
        String salt = user.getEmail() + user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(salt.getBytes()));
        return user;
    }
}
