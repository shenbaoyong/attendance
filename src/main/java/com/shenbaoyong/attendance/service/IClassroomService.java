package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.Classroom;

import java.util.List;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
public interface IClassroomService {
    List<Classroom> getClassroomList();
    String getClassroomNameById(Integer classroomId);
}
