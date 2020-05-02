package com.gary.accounts.convert;

import com.gary.accounts.bean.dto.UserInfoDTO;
import com.gary.accounts.dao.entity.UserInfo;
import org.springframework.beans.BeanUtils;

/**
 * @author 丶武僧
 */
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
