package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.CourseSchedul;
import com.shenbaoyong.attendance.pojo.CourseSchedulExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseSchedulMapper {
    long countByExample(CourseSchedulExample example);

    int deleteByExample(CourseSchedulExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseSchedul record);

    int insertSelective(CourseSchedul record);

    List<CourseSchedul> selectByExample(CourseSchedulExample example);

    CourseSchedul selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseSchedul record, @Param("example") CourseSchedulExample example);

    int updateByExample(@Param("record") CourseSchedul record, @Param("example") CourseSchedulExample example);

    int updateByPrimaryKeySelective(CourseSchedul record);

    int updateByPrimaryKey(CourseSchedul record);
}