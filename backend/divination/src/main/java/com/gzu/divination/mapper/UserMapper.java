package com.gzu.divination.mapper;

import com.gzu.divination.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUserId(Long id);  //登录：根据用户ID查询用户
}
