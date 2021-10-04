package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author linZhaolin
 * @since 2021-09-29
 * UmsMemberServiceImpl 对 UmsMemberREgisterParamDTO 的处理：
 * 把 UmsMemberREgisterParamDTO 转换为 数据库要存储的 bean UmsMember
 */

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UmsMember edit(String username) {
        return umsMemberMapper.selectByName(username);
    }

    /*
 spring的BeanUtils.copyProperties
来自org.springframework.beans.BeanUtils包。提供对Java反射和自省API的包装。其主要目的是利用反射机制对JavaBean的属性进行处理
是浅拷贝
使用场景：
如果有两个具有很多相同属性的JavaBean，需要对象之间的赋值，这时候就可以使用这个方法，避免代码中全是get/set之类的代码，可以让代码简洁
BeanUtils.copyProperties(umsMemberREgisterParamDTO,umsMember);
BeanUtils.copyProperties("要转换的类", "转换后的类");
 */

    /*
    *
  PasswordEncoder 接口是用来加密的，这个接口提供的方法：
1、String encode(CharSequence var1); 加密方法，返回加密后的密码。加密后密文的格式主要取决于PasswordEncoder接口实现类实例。
我们这里使用BCryptPasswordEncoder
2、boolean matches(CharSequence var1, String var2); 密码验证，返回密码是否一致。第一个参数是明文密码，第二个参数是加密后的密码（数据库取）
使用BCryptPasswordEncoder进行密码加密和密码验证的流程：
1.注册用户时，使用encode方法，即SHA-256+随机数+密钥把用户输入的密码进行hash处理，得到密码的hash值，然后将其存入数据库中。
2.用户登录时，使用matches方法进行验证。注册的密码并不会进行密码解密（因为密码经过Hash处理，是不可逆的），
而是使用相同的算法把用户输入的密码进行hash处理，得到密码的hash值，然后将其与从数据库中查询到的密码hash值进行比较。
如果两者相同，说明用户输入的密码正确。
* */
    @Override
    public String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {

        UmsMember u = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO,u);
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        u.setPassword(encode);
        umsMemberMapper.insert(u);
        return "success";

    }

    @Override
    public String register() {
        UmsMember u = new UmsMember();
        u.setNickName("c");
        umsMemberMapper.insert(u);
        return "success";
    }

    @Override
    public String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
       //登录时用的用户名查询数据库里面的数据
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        //判断用户或密码是否正确
        if (null!=umsMember){

            String password = umsMember.getPassword();
            //验证密码是否正确,、boolean matches(CharSequence var1, String var2);
            // 密码验证，返回密码是否一致。第一个参数是明文密码，第二个参数是加密后的密码（数据库取）
            //使用BCryptPasswordEncoder进行密码加密和密码验证的流程：
            if(!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(),password)){
                return "密码不正确";
            }
            System.out.println("登录成功");
            return "登录成功" ;
        }
        return "用户名不存在";
    }

}
