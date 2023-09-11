package com.springboot.mall.service;

import com.springboot.mall.entity.User;
import com.springboot.mall.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticateUser(String userId, String userPw) {
        // 사용자 인증 로직
        // 단순하게 userId와 userPw가 일치하는 사용자를 찾아 리턴
        User user = userRepository.findByUserId(userId);
        if (user != null && user.getUserPw().equals(userPw)) {
            return user;
        }
        return null; // 인증 실패 시 null을 리턴
    }
}
