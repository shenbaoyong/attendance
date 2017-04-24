package com.shenbaoyong.attendance.common.pojo;

import com.shenbaoyong.attendance.common.exception.WrongUserException;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;

import java.io.Serializable;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public class LoginUser implements Serializable{
    private AdminUser adminUser;
    private StudentUser studentUser;
    private TeacherUser teacherUser;

    public boolean hasAdminUser(){
        return this.adminUser != null;
    }

    public boolean hasStudentUser(){
        return this.studentUser!= null;
    }

    public boolean hasTeacherUser(){
        return this.teacherUser != null;
    }

    public AdminUser getAdminUser() throws WrongUserException {
        if (this.adminUser == null) {
            throw new WrongUserException("不合法的操作！");
        } else {
            return adminUser;
        }
    }

    public StudentUser getStudentUser() throws WrongUserException {
        if (this.studentUser == null) {
            throw new WrongUserException("不合法的操作！");
        } else {
            return studentUser;
        }
    }

    public TeacherUser getTeacherUser() throws WrongUserException {
        if (this.teacherUser== null) {
            throw new WrongUserException("不合法的操作！");
        } else {
            return teacherUser;
        }
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public void setStudentUser(StudentUser studentUser) {
        this.studentUser = studentUser;
    }

    public void setTeacherUser(TeacherUser teacherUser) {
        this.teacherUser = teacherUser;
    }

    public String getUserEmail() {
        if(adminUser != null){
            return adminUser.getEmail();
        }else if(studentUser != null){
            return studentUser.getEmail();
        }else if(teacherUser != null){
            return teacherUser.getEmail();
        }else {
            return null;
        }
    }

    public Long getUserPhone() {
        if(adminUser != null){
            return adminUser.getPhone();
        }else if(studentUser != null){
            return studentUser.getPhone();
        }else if(teacherUser != null){
            return teacherUser.getPhone();
        }else {
            return null;
        }
    }

    public String getWelcomMsg(){
        if(hasAdminUser()){
            return getAdminUser().getId() + " " + getAdminUser().getName();
        }
        if (hasStudentUser()){
            return getStudentUser().getId() + " " + getStudentUser().getName();
        }
        if (hasTeacherUser()){
            return getTeacherUser().getId() + " " + getTeacherUser().getName();
        }
        return "........";
    }
}
