package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.AttendanceViewMapper;
import com.shenbaoyong.attendance.dao.TeacherUserMapper;
import com.shenbaoyong.attendance.pojo.*;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Service
public class TeacherUserServiceImpl implements ITeacherUserService{

    @Autowired
    TeacherUserMapper teacherUserMapper;
    @Autowired
    AttendanceViewMapper attendanceViewMapper;

    @Override
    public TeacherUser getTeacherUserById(Long id) {
        return teacherUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CourseListVO> getCourseListOfTeacher(Long id) {
        return teacherUserMapper.selectCourseListOfTeacher(id);
    }

    @Override
    public boolean addTeacherUser(TeacherUser teacherUser) {
        try{
            teacherUser.setId(null);
            teacherUserMapper.insertSelective(teacherUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<TeacherUser> getTeacherUserList() {
        try{
            TeacherUserExample example = new TeacherUserExample();
            return teacherUserMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean deleteTeacherById(long id) {
        try{
            teacherUserMapper.deleteByPrimaryKey(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean modifyStudent(TeacherUser teacherUser) {
        try {
            teacherUserMapper.updateByPrimaryKey(teacherUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void updatestatus(Integer weekId, Integer id, Integer studentId, Byte flag) {
        attendanceViewMapper.updatestatus(weekId, id, studentId, flag);
    }
}
