package com.msb.dongbao.portal.web.controller;

import com.msb.donbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.portal.web.code.ImageCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@RestController
@RequestMapping("/code")
public class VerifyCodeController {


    String attrName="verifyCode";

    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        try{
            ImageCode imageCode=ImageCode.getInstance();

            //验证码的值
            String code=imageCode.getCode();

            request.getSession().setAttribute(attrName,code);

            //验证码图片
            ByteArrayInputStream image=imageCode.getImage();

            response.setContentType("image/jpeg");
            byte[] bytes = new byte[1024];
            try(ServletOutputStream out= response.getOutputStream()){
                while(image.read(bytes) !=-1){
                    out.write(bytes);
                }
            }
        }catch(Exception e){
            System.out.println("异常");
        }
    }
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verfiy(String verifyCode,HttpServletRequest request){
        String s=request.getSession().getAttribute(attrName).toString();
        System.out.println("时间：" + s);
        if (verifyCode.equals(s)){
            return "验证码校验通过";

        }
        return "验证码校验不通过";
    }

    @GetMapping("/generator-base64")
    @TokenCheck(required = false)
    public String generatorCodeBase64(HttpServletRequest request, HttpServletResponse response) {
        try{
            ImageCode imageCode=ImageCode.getInstance();

            //验证码的值
            String code=imageCode.getCode();

            request.getSession().setAttribute(attrName,code);

            //验证码图片
            ByteArrayInputStream image=imageCode.getImage();
           //声明一个输出IO流，以便可以向前端响应图片
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


            byte[] bytes = new byte[1024];
            int r=0;
           while((r = image.read(bytes,0,1024))>0){
               byteArrayOutputStream.write(bytes,0,r);
           }
           //将输出流数据转换成字节数组
           byte[] data=byteArrayOutputStream.toByteArray();
          //返回base64字符串
            return Base64.getEncoder().encodeToString(data);

        }catch(Exception e){
            System.out.println("异常");
            return "";
        }
    }
}
