package com.gary.accounts.manager;

import com.gary.accounts.entity.User;
import com.gary.accounts.entity.UserExample;
import com.gary.accounts.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserManager {

    private final UserMapper userInfoMapper;

    public UserManager(UserMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public User findUserByNameAndPassword(String email, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> userList = userInfoMapper.selectByExample(example);
        return userList.isEmpty() ? null : userList.get(0);
    }

    public Boolean insertUser(User user){
        return userInfoMapper.insert(user) > 0;
    }
}
