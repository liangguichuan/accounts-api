package com.gary.accounts.bean.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiAuthDTO implements Serializable {

    private static final long serialVersionUID = -1926693163597277421L;

    private Long userId;

    private String api_key;

    private String token;
}
