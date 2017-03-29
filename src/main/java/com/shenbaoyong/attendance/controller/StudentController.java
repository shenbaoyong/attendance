package com.shenbaoyong.attendance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@RestController
public class StudentController {
    @ResponseBody
    @RequestMapping(value = "/")
    String home() {
        return "Hello World!";
    }
}
