package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.StudentUserMapper;
import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.CourseSchedul;
import com.shenbaoyong.attendance.pojo.StudentUser;
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

    @Override
    public StudentUser getStudentUserById(Long id) {
        return studentUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CourseListVO> getCourseListOfStudent(Long id) {
        return studentUserMapper.selectCourseListOfStudent(id);
    }
}
