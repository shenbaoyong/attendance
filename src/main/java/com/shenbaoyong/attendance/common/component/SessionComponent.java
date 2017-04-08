package com.shenbaoyong.attendance.common.component;

import com.shenbaoyong.attendance.common.constents.UserConstants;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Component
public class SessionComponent {

    @Autowired
    HttpServletRequest request;

    public void setLoginUser(AdminUser adminUser){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            loginUser.setAdminUser(adminUser);
        }else{
            loginUser = new LoginUser();
            loginUser.setAdminUser(adminUser);
        }
        session.setAttribute(UserConstants.LOGIN_USER, loginUser);
        session.setMaxInactiveInterval(3600 * 3);
    }

    public void setLoginUser(StudentUser studentUser){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            loginUser.setStudentUser(studentUser);
        }else{
            loginUser = new LoginUser();
            loginUser.setStudentUser(studentUser);
        }
        session.setAttribute(UserConstants.LOGIN_USER, loginUser);
        session.setMaxInactiveInterval(3600 * 3);
    }


    public void setLoginUser(TeacherUser teacherUser){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            loginUser.setTeacherUser(teacherUser);
        }else{
            loginUser = new LoginUser();
            loginUser.setTeacherUser(teacherUser);
        }
        session.setAttribute(UserConstants.LOGIN_USER, loginUser);
        session.setMaxInactiveInterval(3600 * 3);
    }

    public AdminUser getAdminUser(){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            return loginUser.getAdminUser();
        }else {
            return null;
        }
    }

    public StudentUser getStudentUSer(){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            return loginUser.getStudentUser();
        }else {
            return null;
        }
    }

    public TeacherUser getTeacherUser(){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        if(loginUser != null){
            return loginUser.getTeacherUser();
        }else {
            return null;
        }
    }

    public void removeLoginUser(){
        HttpSession session = request.getSession();
        session.removeAttribute(UserConstants.LOGIN_USER);
    }

    public LoginUser getLoginUser(){
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser)session.getAttribute(UserConstants.LOGIN_USER);
        return loginUser;
    }
}
