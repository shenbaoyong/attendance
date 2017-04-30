package com.shenbaoyong.attendance.dao;

import com.shenbaoyong.attendance.pojo.Academy;
import com.shenbaoyong.attendance.pojo.AcademyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademyMapper {
    long countByExample(AcademyExample example);

    int deleteByExample(AcademyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Academy record);

    int insertSelective(Academy record);

    List<Academy> selectByExample(AcademyExample example);

    Academy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByExample(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}