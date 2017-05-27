package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.AdminUserMapper;
import com.shenbaoyong.attendance.dao.StudentUserMapper;
import com.shenbaoyong.attendance.dao.TeacherUserMapper;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import com.shenbaoyong.attendance.service.IGebackPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shen Baoyong on 2017/5/25.
 */
@Service
public class GetbackPasswordServiceImpl implements IGebackPasswordService{
    @Autowired
    StudentUserMapper studentUserMapper;
    @Autowired
    TeacherUserMapper teacherUserMapper;
    @Autowired
    AdminUserMapper adminUserMapper;

    Logger logger = LoggerFactory.getLogger(GetbackPasswordServiceImpl.class);

    @Override
    public boolean getbackPassword(String newPassword, String phone) {
        try {
            StudentUser studentUser = studentUserMapper.selectStudentUserByPhone(Long.parseLong(phone));
            if(studentUser != null){
                studentUser.setPassword(newPassword);
                studentUserMapper.updateByPrimaryKey(studentUser);
                return true;
            }

            TeacherUser teacherUser = teacherUserMapper.selectTeacherUserByPhone(Long.parseLong(phone));
            if(teacherUser != null){
                teacherUser.setPassword(newPassword);
                teacherUserMapper.updateByPrimaryKey(teacherUser);
                return true;
            }

            AdminUser adminUser = adminUserMapper.selectAdminUserByPhone(Long.parseLong(phone));
            if(adminUser != null){
                adminUser.setPassword(newPassword);
                adminUserMapper.updateByPrimaryKey(adminUser);
                return true;
            }
            return false;
        }catch (Exception e){
            logger.error("找回密码出错 手机号" + phone,e);
            return false;
        }

    }
}
