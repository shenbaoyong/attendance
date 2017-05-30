package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.AttendanceView;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/5/30.
 */
public interface IAttendanceViewService {
    List<AttendanceView> getAttendanceViewOfStudent(StudentUser studentUser, Integer courseSchedualId);
    List<AttendanceView> getAttendanceViewOfTeacher(Integer courseSchedualId);

}
