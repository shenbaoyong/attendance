package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.CourseList;
import com.shenbaoyong.attendance.pojo.CourseListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseListMapper {
    long countByExample(CourseListExample example);

    int deleteByExample(CourseListExample example);

    int insert(CourseList record);

    int insertSelective(CourseList record);

    List<CourseList> selectByExample(CourseListExample example);

    int updateByExampleSelective(@Param("record") CourseList record, @Param("example") CourseListExample example);

    int updateByExample(@Param("record") CourseList record, @Param("example") CourseListExample example);
}