package com.shenbaoyong.attendance.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.shenbaoyong.attendance.dao.CourseListMapper;
import com.shenbaoyong.attendance.dao.StudentUserMapper;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.*;
import com.shenbaoyong.attendance.service.IStudentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Service
public class StudentUserServiceImpl implements IStudentUserService{

    @Autowired
    StudentUserMapper studentUserMapper;
    @Autowired
    CourseListMapper courseListMapper;

    @Override
    public StudentUser getStudentUserById(Long id) {
        return studentUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CourseListVO> getCourseListOfStudent(Long id) {
        return studentUserMapper.selectCourseListOfStudent(id);
    }

    @Override
    public List<CourseList> getCourseListOfStudent(Long id, int dayOfWeek) {
        CourseListExample example = new CourseListExample();
        CourseListExample.Criteria criteria = example.createCriteria();
        criteria.andDayOfWeekEqualTo(dayOfWeek);
        return courseListMapper.selectByExample(example);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        try{
            studentUserMapper.deleteByPrimaryKey(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean modifyStudent(StudentUser studentUser) {
        try {
            studentUserMapper.updateByPrimaryKey(studentUser);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean addStudentUser(StudentUser studentUser) {
        try{
            studentUser.setId(null);
            studentUserMapper.insertSelective(studentUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<StudentUser> getStudentUserList(Integer classroomId) {
        try{
            StudentUserExample studentUserExample = new StudentUserExample();
            StudentUserExample.Criteria criteria = studentUserExample.createCriteria();
            criteria.andClassroomIdEqualTo(classroomId);
            return studentUserMapper.selectByExample(studentUserExample);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public BaseResult changePassword(Long studentId, String oldPassword, String newPassword, String newPasswordRepeat) {
        StudentUser studentUser = studentUserMapper.selectByPrimaryKey(studentId);
        if(!studentUser.getPassword().equals(oldPassword)){
            return BaseResult.error("旧密码不正确");
        }
        if (!newPassword.equals(newPasswordRepeat)){
            return BaseResult.error("两个新密码不一致");
        }
        studentUser.setPassword(newPassword);
        studentUserMapper.updateByPrimaryKeySelective(studentUser);
        return BaseResult.ok("更新密码成功");
    }
}
