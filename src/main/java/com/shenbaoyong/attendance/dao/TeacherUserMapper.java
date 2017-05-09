package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import com.shenbaoyong.attendance.pojo.TeacherUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherUserMapper {
    long countByExample(TeacherUserExample example);

    int deleteByExample(TeacherUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherUser record);

    int insertSelective(TeacherUser record);

    List<TeacherUser> selectByExample(TeacherUserExample example);

    TeacherUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherUser record, @Param("example") TeacherUserExample example);

    int updateByExample(@Param("record") TeacherUser record, @Param("example") TeacherUserExample example);

    int updateByPrimaryKeySelective(TeacherUser record);

    int updateByPrimaryKey(TeacherUser record);

    List<CourseListVO> selectCourseListOfTeacher(Long id);
}