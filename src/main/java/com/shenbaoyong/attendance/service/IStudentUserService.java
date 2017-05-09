package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.pojo.CourseSchedul;
import com.shenbaoyong.attendance.pojo.StudentUser;
import org.apache.ibatis.annotations.Param;
import org.assertj.core.error.ShouldBeSymbolicLink;

import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public interface IStudentUserService {
    StudentUser getStudentUserById(Long id);

    List<CourseListVO> getCourseListOfStudent(Long id);

    boolean deleteStudentById(Long id);

    boolean modifyStudent(StudentUser studentUser);

    boolean addStudentUser(StudentUser studentUser);

    List<StudentUser> getStudentUserList();

}
