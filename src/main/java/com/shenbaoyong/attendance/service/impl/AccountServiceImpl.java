package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import com.shenbaoyong.attendance.service.IAccountService;
import com.shenbaoyong.attendance.service.IAdminUserService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Service
public class AccountServiceImpl implements IAccountService{

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    IStudentUserService studentUserService;
    @Autowired
    ITeacherUserService teacherUserService;
    @Autowired
    IAdminUserService adminUserService;
    @Autowired
    SessionComponent sessionComponent;

    @Override
    public BaseResult login(String userType, long id, String password) {
        BaseResult result = null;
        switch (userType){
            case "1":  //学生
                result = studentUserLogin(id, password);
                break;
            case "2":   //老师
                result = teacherUserLogin(id, password);
                break;
            case "3":  //管理员
                result = adminUserLogin(id, password);
                break;
        }
        if(result == null) {
            result = BaseResult.error("未知的用户类型");
        }
        return result;
    }

    @Override
    public BaseResult logout() {
        LoginUser loginUser = sessionComponent.getLoginUser();
        if (loginUser == null) {
            logger.info("当前没用用户登陆或者会话已过期");
            return BaseResult.error("当前没用用户登陆或者会话已过期");
        }
        sessionComponent.removeLoginUser();
        return BaseResult.ok(true);
    }

    private BaseResult adminUserLogin(long id, String password) {
        logger.info("管理员帐号{}尝试登陆", id);
        AdminUser adminUser = adminUserService.getAdminUserById(id);
        if(adminUser== null){
            logger.info("管理员帐号{}, 无此用户", id);
            return BaseResult.error("无此用户");
        }else if( !password.equals(adminUser.getPassword()) ){
            logger.info("管理员帐号{}, 密码输错", id);
            return BaseResult.error("密码错误");
        }
        logger.info("管理员帐号{}, {}登陆成功", id, adminUser.getName());
        sessionComponent.setLoginUser(adminUser);
        return BaseResult.ok(true);
    }

    private BaseResult teacherUserLogin(long id, String password) {
        logger.info("老师帐号{}尝试登陆", id);
        TeacherUser teacherUser = teacherUserService.getTeacherUserById(id);
        if(teacherUser == null){
            logger.info("老师帐号{}, 无此用户", id);
            return BaseResult.error("无此用户");
        }else if( !password.equals(teacherUser.getPassword()) ){
            logger.info("老师帐号{}, 密码输错", id);
            return BaseResult.error("密码错误");
        }
        logger.info("老师帐号{}, {}登陆成功", id, teacherUser.getName());
        sessionComponent.setLoginUser(teacherUser);
        return BaseResult.ok(true);
    }

    private BaseResult studentUserLogin(long id, String password) {
        logger.info("学号{}尝试登陆", id);
        StudentUser studentUser = studentUserService.getStudentUserById(id);
        if(studentUser == null){
            logger.info("学号{}, 无此用户", id);
            return BaseResult.error("无此用户");
        }else if( !password.equals(studentUser.getPassword()) ){
            logger.info("学号{}, 密码输错", id);
            return BaseResult.error("密码错误");
        }
        logger.info("学号{}, {}登陆成功", id, studentUser.getName());
        sessionComponent.setLoginUser(studentUser);
        return BaseResult.ok(true);
    }
}
