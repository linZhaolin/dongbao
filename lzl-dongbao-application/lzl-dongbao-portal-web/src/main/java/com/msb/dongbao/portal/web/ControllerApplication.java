package com.msb.dongbao.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.msb"})
@MapperScan("com.msb.dongbao.ums.mapper")
public class ControllerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ControllerApplication.class,args);
    }
    @Bean
    public PasswordEncoder passwordEncoer(){
return new BCryptPasswordEncoder();
    }
}
