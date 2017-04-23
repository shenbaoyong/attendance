package com.shenbaoyong.attendance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Baoyong on 2017/4/23.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String helloHtml(Model model){
        model.addAttribute("name", "Dear");
        return "helloHtml";
    }
}
