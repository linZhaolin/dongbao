package com.msb.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author linZhaolin
 * @since 2021-09-29
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {
    //查询by用户名
  UmsMember selectByName(String name);

}
