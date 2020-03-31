package com.chuan.accounts.convert;

import com.chuan.accounts.bean.dto.UserInfoDTO;
import com.chuan.accounts.dao.entity.UserInfo;
import org.springframework.beans.BeanUtils;

public class UserDtoConverter {

    public static UserInfoDTO convert(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserInfoDTO dto = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, dto);
        return dto;
    }
}
