package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.CourseTime;
import com.shenbaoyong.attendance.pojo.CourseTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTimeMapper {
    long countByExample(CourseTimeExample example);

    int deleteByExample(CourseTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTime record);

    int insertSelective(CourseTime record);

    List<CourseTime> selectByExample(CourseTimeExample example);

    CourseTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTime record, @Param("example") CourseTimeExample example);

    int updateByExample(@Param("record") CourseTime record, @Param("example") CourseTimeExample example);

    int updateByPrimaryKeySelective(CourseTime record);

    int updateByPrimaryKey(CourseTime record);
}