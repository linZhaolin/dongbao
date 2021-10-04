package com.msb.dongbao.portal.web.md5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;


public class EncoderOrSeptemberTest {

/*
* MD5不可逆，但是可以用彩虹表破解
* */
    @Test
    public void md5(){
        String sourceString="12345";
        String s= DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第一次加密值："+ s);

        String s1 = DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第二次加密值：" + s1);
    }

    @Test
    public void bcrypt(){
        String sourcesString="123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(sourcesString);
        System.out.println("第一次加密值：" + encode);
        boolean matches = bCryptPasswordEncoder.matches(sourcesString, encode);
        System.out.println("第一次验证：" + matches);

        String encode1 = bCryptPasswordEncoder.encode(sourcesString);

        System.out.println("第二次加密值："+ encode1);
        String sourcesString1="linzhaolin";
         matches = bCryptPasswordEncoder.matches(sourcesString1, encode1);
        System.out.println("第二次验证："+ matches);

    }
}
