package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.ClassroomMapper;
import com.shenbaoyong.attendance.pojo.Classroom;
import com.shenbaoyong.attendance.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@Service
public class ClassroomServiceImpl implements IClassroomService{
    @Autowired
    ClassroomMapper classroomMapper;
    @Override
    public List<Classroom> getClassroomList(int offset, int limit) {
        return classroomMapper.quaryAll(offset, limit);
    }
}
