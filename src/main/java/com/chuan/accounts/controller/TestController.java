package com.chuan.accounts.controller;

import com.alibaba.fastjson.JSON;
import com.chuan.accounts.bean.business.BusinessException;
import com.chuan.accounts.bean.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test/{id}")
    public String testGet(@PathVariable("id") Long id){
        if(id == null){
            log.warn("id 不能为空");
        }
        log.info("id 为: {}", id);
        return "123";
    }

    @PostMapping("/login")
    public String testPost(@RequestBody @Valid LoginVO loginVO){
        return JSON.toJSONString(loginVO);
    }

    @GetMapping("/error")
    public void error(){
        throw new BusinessException("test error");
    }
}
