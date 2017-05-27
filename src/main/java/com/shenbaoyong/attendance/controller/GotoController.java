package com.shenbaoyong.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shen Baoyong on 2017/5/27.
 */
@Controller
@RequestMapping("/goto")
public class GotoController {

    @GetMapping("addStudentPage")
    public String addStudentPage(Model model){
        return "addstudent";
    }



}
