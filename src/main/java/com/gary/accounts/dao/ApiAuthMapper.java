package com.gary.accounts.dao;

import com.gary.accounts.dao.entity.ApiAuth;
import com.gary.accounts.dao.entity.ApiAuthExample;

import java.util.List;

public interface ApiAuthMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(ApiAuth record);

    int insertSelective(ApiAuth record);

    List<ApiAuth> selectByExample(ApiAuthExample example);

    ApiAuth selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(ApiAuth record);

    int updateByPrimaryKey(ApiAuth record);
}