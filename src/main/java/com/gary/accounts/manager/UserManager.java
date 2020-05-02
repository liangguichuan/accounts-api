package com.gary.accounts.manager;

import com.gary.accounts.bean.dto.UserInfoDTO;
import com.gary.accounts.convert.UserDtoConverter;
import com.gary.accounts.dao.UserInfoMapper;
import com.gary.accounts.dao.entity.UserInfo;
import com.gary.accounts.dao.entity.UserInfoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserManager {

    private UserInfoMapper userInfoMapper;

    public UserManager(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfoDTO findUserByNameAndPassword(String email, String password) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<UserInfo> userList = userInfoMapper.selectByExample(example);
        return UserDtoConverter.convert(userList.isEmpty() ? null : userList.get(0));
    }
}
