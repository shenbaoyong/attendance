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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Baoyong on 2017/4/30.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    IStudentUserService studentUserService;


    @RequestMapping("/list")
    public String getStudentList(@RequestBody Map<String, Object> params,  Model model){
        List<StudentUser> studentUserList = studentUserService.getStudentUserList();
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/add")
    public String addStudent(StudentUser studentUser ,  Model model){
        studentUser.setId(null);
        studentUserService.addStudentUser(studentUser);
        List<StudentUser> studentUserList = studentUserService.getStudentUserList();
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("id") String id , Model model){
        if(StringUtils.isEmpty(id)){
            id = "0";
        }
        studentUserService.deleteStudentById(Long.parseLong(id));
        List<StudentUser> studentUserList = studentUserService.getStudentUserList();
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/modify")
    public String modifyStudent(StudentUser student,  Model model){
        studentUserService.modifyStudent(student);
        List<StudentUser> studentUserList = studentUserService.getStudentUserList();
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

}
