package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.constents.UserConstants;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.UserVO;
import com.shenbaoyong.attendance.service.IAccountService;
import com.shenbaoyong.attendance.service.IDeptService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    IDeptService deptService;

    @PostMapping("/login")
    public String login(UserVO userVO, Model model, HttpServletRequest request){
        try{
            String userType = userVO.getUserType();
            long id = Long.parseLong(userVO.getUserId());
            String password = userVO.getPassword();
            BaseResult result = accountService.login(userType, id, password);

            if(result.isSuccess()){
                LoginUser loginUser = sessionComponent.getLoginUser();
                loginUser = sessionComponent.getLoginUser();
                if(loginUser.hasAdminUser()){
                    request.getSession().setAttribute("deptlist",deptService.getDeptList());
                    return "adminpage";
                }else if(loginUser.hasStudentUser()){
                    List<CourseListVO> courseListVOList = studentUserService.getCourseListOfStudent(loginUser.getStudentUser().getId());
                    model.addAttribute("courseList", courseListVOList);
                    return "studentCourseList";
                }else if(loginUser.hasTeacherUser()){
                    List<CourseListVO> courseListVOList = teacherUserService.getCourseListOfTeacher(loginUser.getTeacherUser().getId());
                    model.addAttribute("courseList", courseListVOList);
                    return "teacherCourseList";
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
    public String logout(){
        try {
            BaseResult result = accountService.logout();
            return "index";
        }catch (Exception e){
            logger.error("退出失败",e);
            return "index";
        }
    }
}
