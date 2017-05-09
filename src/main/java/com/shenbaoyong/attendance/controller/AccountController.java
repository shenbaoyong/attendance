package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.constents.UserConstants;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.UserVO;
import com.shenbaoyong.attendance.service.IAccountService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    IAccountService accountService;
    @Autowired
    IStudentUserService studentUserService;
    @Autowired
    ITeacherUserService teacherUserService;

    @PostMapping("/login")
    public String login(UserVO userVO, Model model){
        try{
            String userType = userVO.getUserType();
            long id = Long.parseLong(userVO.getUserId());
            String password = userVO.getPassword();
            BaseResult result = accountService.login(userType, id, password);

            if(result.isSuccess()){
                String welcomMsg = sessionComponent.getLoginUser().getWelcomMsg();
                model.addAttribute("msg", welcomMsg);
                if(sessionComponent.getLoginUser().hasStudentUser()){
                    List<CourseListVO> courseListVOList = studentUserService.getCourseListOfStudent(1304030221L);
                    model.addAttribute("courseList", courseListVOList);
                    return "studentCourseList";
                }else if(sessionComponent.getLoginUser().hasTeacherUser()){
                    List<CourseListVO> courseListVOList = teacherUserService.getCourseListOfTeacher(1304030221L);
                    model.addAttribute("courseList", courseListVOList);
                    return "teacherCourseList";
                }else if (sessionComponent.getLoginUser().hasAdminUser()){
                    return "adminMainPage";
                }
            }
            model.addAttribute("msg", result.getError());
            return "index";
        }catch (Exception e){
            model.addAttribute("msg", "login failed");
            return "helloHtml";
        }
    }

    @GetMapping("/logout")
    public BaseResult logout(){
        try {
            BaseResult result = accountService.logout();
            return result;
        }catch (Exception e){
            logger.error("退出失败",e);
            return BaseResult.error("退出失败");
        }
    }


}
