package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.AttendanceViewMapper;
import com.shenbaoyong.attendance.pojo.AttendanceView;
import com.shenbaoyong.attendance.pojo.AttendanceViewExample;
import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.service.IAttendanceViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/5/30.
 */
@Service
public class AttendanceViewServiceImpl implements IAttendanceViewService{
    @Autowired
    AttendanceViewMapper attendanceViewMapper;
    @Override
    public List<AttendanceView> getAttendanceViewOfStudent(StudentUser studentUser, Integer courseSchedualId) {
        AttendanceViewExample attendanceViewExample = new AttendanceViewExample();
        AttendanceViewExample.Criteria criteria = attendanceViewExample.createCriteria();
        criteria.andSidEqualTo(studentUser.getId());
        criteria.andIdEqualTo(courseSchedualId);
        return attendanceViewMapper.selectByExample(attendanceViewExample);
    }

    @Override
    public List<AttendanceView> getAttendanceViewOfTeacher(Integer courseSchedualId) {
        AttendanceViewExample attendanceViewExample = new AttendanceViewExample();
        AttendanceViewExample.Criteria criteria = attendanceViewExample.createCriteria();
        criteria.andIdEqualTo(courseSchedualId);
        return attendanceViewMapper.selectByExample(attendanceViewExample);
    }
}
