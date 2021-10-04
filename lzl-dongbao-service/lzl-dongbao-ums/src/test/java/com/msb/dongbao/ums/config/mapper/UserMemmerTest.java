package com.msb.dongbao.ums.config.mapper;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMemmerTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

       @Test
       void testInsert(){
           UmsMember t = new UmsMember();
           t.setUsername("lsl");
           t.setStatus(0);
           t.setPassword("456");
           t.setNickName("nick");
           t.setEmail("email");
           t.setNote("note");

           umsMemberMapper.insert(t);

       }
}
