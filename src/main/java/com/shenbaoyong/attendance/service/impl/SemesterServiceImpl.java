package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.SemesterMapper;
import com.shenbaoyong.attendance.pojo.Semester;
import com.shenbaoyong.attendance.pojo.SemesterExample;
import com.shenbaoyong.attendance.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/30.
 */
public class SemesterServiceImpl implements ISemesterService{

    @Autowired
    SemesterMapper semesterMapper;

    @Override
    public List<Semester> getSemesterList() {
        SemesterExample semesterExample = new SemesterExample();
        return semesterMapper.selectByExample(semesterExample);
    }

    @Override
    public void addSemester(Semester semester) {
        semesterMapper.insert(semester);
    }

    @Override
    public void deleteSemester(int id) {
        semesterMapper.deleteByPrimaryKey(id);
    }
}
