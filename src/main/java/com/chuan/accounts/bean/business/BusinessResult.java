package com.chuan.accounts.bean.business;

public class BusinessResult<T> {

    private Long code;

    private String msg;

    private T data;

    public BusinessResult(BusinessCode code, T data) {
        this.setCode(code);
        this.setData(data);
    }

    public BusinessResult(BusinessCode code, String msg){
        this.setCode(code);
        this.setMsg(msg);
    }

    public static <T> BusinessResult<T> success(T data){
        return new BusinessResult<T>(BusinessCode.SUCCESS, data);
    }

    public static <T> BusinessResult<T> failed(BusinessCode code, String msg){
        return new BusinessResult<>(code, msg);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(BusinessCode status) {
        this.code = status.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
