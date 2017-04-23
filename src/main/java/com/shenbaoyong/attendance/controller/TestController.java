package com.shenbaoyong.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shen Baoyong on 2017/4/23.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String helloHtml(Model model){
        model.addAttribute("hello", "你好");
        model.addAttribute("name", "shenbaoyong");
        return "helloHtml";
    }
}
