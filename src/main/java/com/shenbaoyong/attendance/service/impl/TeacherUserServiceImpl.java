package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.TeacherUserMapper;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Service
public class TeacherUserServiceImpl implements ITeacherUserService{

    @Autowired
    TeacherUserMapper teacherUserMapper;

    @Override
    public TeacherUser getTeacherUserById(Long id) {
        return teacherUserMapper.selectByPrimaryKey(id);
    }
}
