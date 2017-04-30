package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.Semester;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/30.
 */
public interface ISemesterService {

    List<Semester> getSemesterList();

    void addSemester(Semester semester);

    void deleteSemester(int id);
}
