package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.DeptMapper;
import com.shenbaoyong.attendance.pojo.Classroom;
import com.shenbaoyong.attendance.pojo.Dept;
import com.shenbaoyong.attendance.pojo.DeptExample;
import com.shenbaoyong.attendance.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/5/28.
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList() {
        DeptExample example = new DeptExample();
        return  deptMapper.selectByExample(example);
    }

    @Override
    public String getDeptNameById(Integer deptId) {
        Dept dept = deptMapper.selectByPrimaryKey(deptId);
        if(dept == null){
            return "无";
        }
        return  dept.getName();
    }


}
