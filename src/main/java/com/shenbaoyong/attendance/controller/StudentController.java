package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.*;
import com.shenbaoyong.attendance.service.IStudentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/course/list")
    public String getStudentCourseList(String week,  Model model){

        if(StringUtils.isEmpty(week) || "0".equals(week)){
            List<CourseListVO> courseListVOList = studentUserService.getCourseListOfStudent(1304030221L);
            model.addAttribute("courseList", courseListVOList);
        }else {
            List<CourseList> courseListVOList =  studentUserService.getCourseListOfStudent(1304030221L,Integer.parseInt(week));
            model.addAttribute("courseList", courseListVOList);
        }
        model.addAttribute("msg", "星期" + week +  " 的课程");
        return "studentCourseList";
    }

    @RequestMapping("/list")
    public String getStudentList(@RequestBody Map<String, Object> params,  Model model){
        if(StringUtils.isEmpty(params) || StringUtils.isEmpty(params.get("classroom_id"))){
            return "studentList";
        }
        String classroomId = (String)params.get("classroom_id");
        List<StudentUser> studentUserList = studentUserService.getStudentUserList(Integer.parseInt(classroomId));
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/add")
    public String addStudent(StudentUser studentUser ,  Model model) {
        return null;
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("id") String id , Model model){
        if(StringUtils.isEmpty(id)){
            id = "0";
        }
        studentUserService.deleteStudentById(Long.parseLong(id));
        StudentUser studentUser = studentUserService.getStudentUserById(Long.parseLong(id));
        List<StudentUser> studentUserList = studentUserService.getStudentUserList(studentUser.getClassroomId());
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/modify")
    public String modifyStudent(StudentUser student,  Model model){
        studentUserService.modifyStudent(student);
        List<StudentUser> studentUserList = studentUserService.getStudentUserList(student.getClassroomId());
        model.addAttribute("studentList", studentUserList);
        return "studentList";
    }

    @RequestMapping("/course/detail")
    public String getCourseDetail(Integer courseSchedulId,  Model model){
        //studentUserService.modifyStudent(student);
        //List<StudentUser> studentUserList = studentUserService.getStudentUserList();
        model.addAttribute("id", courseSchedulId);

        return "studentACourseAttendanceInfo";
    }

    @RequestMapping("/changePassword")
    public String changePassword(StudentChangePasswordVO vo, Model model){
        StudentUser studentUser = sessionComponent.getLoginUser().getStudentUser();
        Long studentId = studentUser.getId();
        String oldPassword = vo.getOldPassword();
        String newPassword = vo.getNewPassword();
        String newPasswordRepeat = vo.getNewPasswordRepeat();
        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(newPasswordRepeat)){
            model.addAttribute("msg", "密码不能为空");
            return "studentChangePassword";
        }
        try{
            BaseResult result = studentUserService.changePassword(studentId, oldPassword, newPassword, newPasswordRepeat);
            if(result.isSuccess()){
                model.addAttribute("msg", "更新密码成功");
                return "studentChangePassword";
            }else{
                model.addAttribute("msg", result.getError());
                return "studentChangePassword";
            }

        }catch (Exception e){
            model.addAttribute("msg", "更新密码失败");
            return "studentChangePassword";
        }
    }

}
