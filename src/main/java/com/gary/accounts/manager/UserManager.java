package com.gary.accounts.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gary.accounts.entity.User;
import com.gary.accounts.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserManager {

    private final UserMapper userMapper;

    public UserManager(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUserByNameAndPassword(String email, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email).eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }

    public List<User> findUserByEmailOrPhone(String email, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email).or().eq("phone", password);
        return userMapper.selectList(queryWrapper);
    }

    public Boolean insertUser(User user) {
        return userMapper.insert(user) > 0;
    }

    public Boolean updatePassword(String oldPassword, String newPassword){
        User user = new User();
        user.setPassword(newPassword);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("passwrod", oldPassword);
        return userMapper.update(user, updateWrapper) > 0;
    }

}
