package com.msb.dongbao.portal.web.controller;


import com.msb.donbao.common.base.result.ResultWrapper;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public UmsMember edit(@RequestBody String username){
     return umsMemberService.edit(username);
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
 @PostMapping
    public String login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
    return umsMemberService.login(umsMemberLoginParamDTO);
 }




}

