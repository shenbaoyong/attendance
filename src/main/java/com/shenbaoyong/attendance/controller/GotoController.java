package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.pojo.Classroom;
import com.shenbaoyong.attendance.pojo.Dept;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.service.IClassroomService;
import com.shenbaoyong.attendance.service.IDeptService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/5/27.
 */
@Controller
@RequestMapping("/goto")
public class GotoController {

    @Autowired
    IStudentUserService studentUserService;
    @Autowired
    IClassroomService classroomService;
    @Autowired
    IDeptService deptService;

    @GetMapping("/addStudentPage")
    public String addStudentPage(Model model){
        return "addstudent";
    }

    @GetMapping("/studentlist")
    public String studentlistPage(Model model){
        List<Classroom> classroomList = classroomService.getClassroomList();
        model.addAttribute("classroomList", classroomList);
        return "studentlist";
    }

    @GetMapping("/teacherlist")
    public String teacherlistPage(Model model){
        return "teacherlist";
    }

    @RequestMapping("/modifyStudentPage")
    public String modifyStudentPage(String id, Model model){
        StudentUser studentUser = studentUserService.getStudentUserById(Long.parseLong(id));
        model.addAttribute("student", studentUser);
        return "modifystudent";
    }


    @RequestMapping("/viewAttendance")
    public String viewAttendance(Model model){
        return "viewAttendance";
    }

}
