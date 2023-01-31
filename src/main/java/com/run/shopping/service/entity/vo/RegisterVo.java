package com.run.shopping.service.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String nickName;

    private  String password;

    private  String  phone;

    private  String code;
}
