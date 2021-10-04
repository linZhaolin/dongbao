package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author linZhaolin
 * @since 2021-09-29
 */
public interface UmsMemberService {
    UmsMember edit(String username);

    String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    String register();

    String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);


}
