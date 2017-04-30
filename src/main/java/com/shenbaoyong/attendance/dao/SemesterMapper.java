package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.Semester;
import com.shenbaoyong.attendance.pojo.SemesterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemesterMapper {
    long countByExample(SemesterExample example);

    int deleteByExample(SemesterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Semester record);

    int insertSelective(Semester record);

    List<Semester> selectByExample(SemesterExample example);

    Semester selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByExample(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
}