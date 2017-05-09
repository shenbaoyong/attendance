package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.TeacherUser;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public interface ITeacherUserService {
    TeacherUser getTeacherUserById(Long id);
    List<CourseListVO> getCourseListOfTeacher(Long id);

    boolean addTeacherUser(TeacherUser teacherUser);

    List<TeacherUser> getTeacherUserList();

    boolean deleteTeacherById(long id);

    boolean modifyStudent(TeacherUser teacherUser);
}
