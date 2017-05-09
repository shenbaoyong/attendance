package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.CourseSchedul;
import com.shenbaoyong.attendance.pojo.StudentUser;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public interface IStudentUserService {
    StudentUser getStudentUserById(Long id);

    List<CourseListVO> getCourseListOfStudent(Long id);
}
