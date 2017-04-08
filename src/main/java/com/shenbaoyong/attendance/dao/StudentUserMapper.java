package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.StudentUser;
import com.shenbaoyong.attendance.pojo.StudentUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentUserMapper {
    long countByExample(StudentUserExample example);

    int deleteByExample(StudentUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentUser record);

    int insertSelective(StudentUser record);

    List<StudentUser> selectByExample(StudentUserExample example);

    StudentUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentUser record, @Param("example") StudentUserExample example);

    int updateByExample(@Param("record") StudentUser record, @Param("example") StudentUserExample example);

    int updateByPrimaryKeySelective(StudentUser record);

    int updateByPrimaryKey(StudentUser record);
}