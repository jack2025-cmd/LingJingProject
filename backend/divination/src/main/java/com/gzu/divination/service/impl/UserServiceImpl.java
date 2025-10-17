package com.gzu.divination.service.impl;

import com.gzu.divination.common.exception.MyException;
import com.gzu.divination.entity.User;
import com.gzu.divination.mapper.UserMapper;
import com.gzu.divination.service.UserService;
import com.gzu.divination.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户ID查询用户信息
     */
    @Override
    // 获取个人信息
    public User getUserById(String token)  {
        Long userId = JwtUtils.getUserId(token);
        return userMapper.selectByUserId(userId);
    }
}
