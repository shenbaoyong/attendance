package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.pojo.*;
import com.shenbaoyong.attendance.service.IAttendanceViewService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Baoyong on 2017/5/9.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    ITeacherUserService teacherUserService;


    @RequestMapping("/list")
    public String getTeacherList(@RequestBody Map<String, Object> params, Model model){
        List<TeacherUser> teacherUserList = teacherUserService.getTeacherUserList();
        model.addAttribute("teacherList", teacherUserList);
        return "teacherList";
    }

    @RequestMapping("/add")
    public String addTeacher(TeacherUser teacherUser,  Model model){
        teacherUser.setId(null);
        teacherUserService.addTeacherUser(teacherUser);
        List<TeacherUser> teacherUserList = teacherUserService.getTeacherUserList();
        model.addAttribute("teacherList", teacherUserList);
        return "teacherList";
    }

    @RequestMapping("/delete")
    public String deleteTeacher(@RequestParam("id") String id , Model model){
        if(StringUtils.isEmpty(id)){
            id = "0";
        }
        teacherUserService.deleteTeacherById(Long.parseLong(id));
        List<TeacherUser> teacherUserList = teacherUserService.getTeacherUserList();
        model.addAttribute("teacherList", teacherUserList);
        return "teacherList";
    }

    @RequestMapping("/modify")
    public String modifyTeacher(TeacherUser teacherUser, Model model){
        teacherUserService.modifyStudent(teacherUser);
        List<TeacherUser> teacherUserList = teacherUserService.getTeacherUserList();
        model.addAttribute("teacherList", teacherUserList);
        return "teacherCourseList";
    }

    @RequestMapping("updatestatus")
    public String updatestatus(Integer weekId, Integer id,Integer studentId, Integer flag, Model model ){
        //model.addAttribute("courseSchedulId", courseSchedulId);
        try{
            teacherUserService.updatestatus(weekId, id, studentId, (byte)flag.intValue());
            logger.info("id" + id + "\n studentID = " + studentId + "\n flag =" + flag);
            List<AttendanceView> list = attendanceViewService.getAttendanceViewOfTeacher(id);
            model.addAttribute("list", list);
            return "teacherACourseAttendanceInfo";
        }catch (Exception e){
            e.printStackTrace();
            logger.error("更改考勤状态出错，" + e);
        }
        return "teacherACourseAttendanceInfo";
    }

    @Autowired
    IAttendanceViewService attendanceViewService;

    @RequestMapping("/course/detail")
    public String getCourseDetail(Integer courseSchedulId,  Model model){
        model.addAttribute("courseSchedulId", courseSchedulId);
        List<AttendanceView> list = attendanceViewService.getAttendanceViewOfTeacher(courseSchedulId);
        model.addAttribute("list", list);
        return "teacherACourseAttendanceInfo";
    }
}
