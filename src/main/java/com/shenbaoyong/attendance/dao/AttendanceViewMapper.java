package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.AttendanceView;
import com.shenbaoyong.attendance.pojo.AttendanceViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceViewMapper {
    long countByExample(AttendanceViewExample example);

    int deleteByExample(AttendanceViewExample example);

    int insert(AttendanceView record);

    int insertSelective(AttendanceView record);

    List<AttendanceView> selectByExample(AttendanceViewExample example);

    int updateByExampleSelective(@Param("record") AttendanceView record, @Param("example") AttendanceViewExample example);

    int updateByExample(@Param("record") AttendanceView record, @Param("example") AttendanceViewExample example);
}