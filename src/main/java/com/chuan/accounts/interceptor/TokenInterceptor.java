package com.chuan.accounts.interceptor;

import com.chuan.accounts.bean.RedisKeyPrefix;
import com.chuan.accounts.bean.vo.UserVO;
import com.chuan.accounts.util.JwtUtil;
import com.chuan.accounts.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    private static final String AUTH = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //TODO 此处的异常返回是否能统一进行封装
        String token = request.getHeader(AUTH);
        if(StringUtils.isBlank(token)){
            log.error("TokenInterceptor.preHandle: token is null");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }
}
