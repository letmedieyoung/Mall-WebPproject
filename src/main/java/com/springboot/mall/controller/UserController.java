package com.springboot.mall.controller;

import com.springboot.mall.entity.User;
import com.springboot.mall.repository.UserRepository;
import com.springboot.mall.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String main() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPw) {
        // 데이터베이스에서 사용자 정보를 조회합니다.
        User user = userRepository.findByUserId(userId);

        if (user != null && user.getUserPw().equals(userPw)) {
            // 로그인 성공 시 세션에 사용자 정보를 저장하고 index 페이지로 리다이렉트합니다.
            request.getSession().setAttribute("userId", userId);
            return "redirect:admin/index";
        } else {
            // 로그인 실패 시 다시 로그인 페이지로 리다이렉트합니다.
            return "redirect:/login";
        }
    }
}