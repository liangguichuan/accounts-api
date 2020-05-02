package com.gary.accounts.bean.business;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 丶武僧
 * 返回数据统一包装，不需要code，将code以http code返回，有异常返回msg
 */

@Data
public class BusinessResult<T> implements Serializable {

    private static final long serialVersionUID = -5209390822512234334L;

    private String msg;

    private T data;

    public BusinessResult(T data){
        this.data = data;
    }

    public BusinessResult(String msg){
        this.msg = msg;
    }

    public static <T> BusinessResult<T> success(T data){
        return new BusinessResult(data);
    }

    public static <T> BusinessResult<T> failed(String msg){
        return new BusinessResult(msg);
    }
}
