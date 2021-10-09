package com.msb.dongbao.portal.web.controller;


import com.msb.donbao.common.base.annotations.TokenCheck;
import com.msb.donbao.common.base.result.ResultWrapper;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.smb.msbdongbaocommonutil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.Result;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author linZhaolin
 * @since 2021-09-29
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {

     @Autowired
     UmsMemberService umsMemberService;

    @GetMapping("edit")
    @TokenCheck
    public ResultWrapper edit(@RequestBody UmsMember umsMember){
     return umsMemberService.edit(umsMember);
    }

    @GetMapping("hello")
    public String test(){
        return "hello";
    }

/*
* 注册
* @param umsMemberRegisterParamDTO
* @Return
*
*
* */

@PostMapping("/register")
 public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        umsMemberService.register(umsMemberRegisterParamDTO);
        return ResultWrapper.getSuccessBuilder().date(null).build();
 }
 /*
 *
 *
 * */
 @GetMapping("regist")
    public String register(){
    umsMemberService.register();
    return "success";
 }
 /*
 * 登录
 * */
 @PostMapping("/login")
    public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
    return umsMemberService.login(umsMemberLoginParamDTO);
 }

 /*
 *  这是测试的 系统中的任意一个接口,
  * 修改用户信息。
  * @param token
  * @return
 * */
 @GetMapping("/test-verify")
public ResultWrapper verify(String token){

//     String s= JwtUtil.parseToken(token);
//     String token1=JwtUtil.createToken(s);
     System.out.println("正常业务");
     return ResultWrapper.getSuccessBuilder().build();
 }



}

