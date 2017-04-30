package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.CourseTable;
import com.shenbaoyong.attendance.pojo.CourseTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTableMapper {
    long countByExample(CourseTableExample example);

    int deleteByExample(CourseTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTable record);

    int insertSelective(CourseTable record);

    List<CourseTable> selectByExample(CourseTableExample example);

    CourseTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTable record, @Param("example") CourseTableExample example);

    int updateByExample(@Param("record") CourseTable record, @Param("example") CourseTableExample example);

    int updateByPrimaryKeySelective(CourseTable record);

    int updateByPrimaryKey(CourseTable record);
}