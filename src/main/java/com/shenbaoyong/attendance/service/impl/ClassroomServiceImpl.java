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
    public List<Classroom> getClassroomList() {
        return classroomMapper.quaryAll(0, 100);
    }

    @Override
    public String getClassroomNameById(Integer classroomId) {
        Classroom classroom = classroomMapper.selectByPrimaryKey(classroomId);
        if(classroom == null){
            return "未知";
        }
        return classroom.getName();
    }
}
