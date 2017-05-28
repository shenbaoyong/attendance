package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.Dept;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/5/28.
 */
public interface IDeptService {
    List<Dept> getDeptList();
    String getDeptNameById(Integer deptId);
}
