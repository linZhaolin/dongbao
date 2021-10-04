package com.msb.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;

//接受前端传过来的参数
@Data
@ToString
public class UmsMemberRegisterParamDTO {
    @Size(min = 1,max=8,message="用户名长度在1-8之间")
    private String username;

    private String password;
    //头像
    private String icon;

    private String email;

    private String nickName;


}
