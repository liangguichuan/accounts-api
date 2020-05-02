package com.gary.accounts.dao;

import com.gary.accounts.dao.entity.UserInfo;
import com.gary.accounts.dao.entity.UserInfoExample;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}