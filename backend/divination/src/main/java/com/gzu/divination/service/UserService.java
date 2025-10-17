package com.gzu.divination.service;

import com.gzu.divination.entity.User;

public interface UserService {
    /**
     * 根据token获得ID查询用户信息
     * @return 用户对象
     */
    User getUserById(String token);
}
