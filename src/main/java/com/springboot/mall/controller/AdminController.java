package com.springboot.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/index")
    public String admin(Model model){

        model.addAttribute("tilte", "스토어 관리");
        model.addAttribute("content", "컨텐트");
        return "admin/index";
    }
}
