package com.springboot.mall.service;

import com.springboot.mall.entity.User;

public interface UserService {

    User authenticateUser(String userId, String userPw);
}
