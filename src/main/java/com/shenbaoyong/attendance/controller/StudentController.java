package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.CourseSchedul;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.service.IStudentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/30.
 */
@Controller
@RequestMapping("/student/course")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    IStudentUserService studentUserService;

    @RequestMapping("/list")
    public String courseList(Model model){
////        LoginUser loginUser = sessionComponent.getLoginUser();
////        StudentUser studentUser = loginUser.getStudentUser();
//        List<CourseListVO> courseListOfStudent = studentUserService.getCourseListOfStudent(1304030221L);
//        model.addAttribute("courseList", courseListOfStudent);
        return "studentCourseList";
    }

}
