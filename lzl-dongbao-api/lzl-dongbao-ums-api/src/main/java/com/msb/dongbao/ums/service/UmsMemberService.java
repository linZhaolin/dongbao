package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.donbao.common.base.result.ResultWrapper;
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
    ResultWrapper edit(UmsMember umsMember);

    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    ResultWrapper register();

    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);


}
