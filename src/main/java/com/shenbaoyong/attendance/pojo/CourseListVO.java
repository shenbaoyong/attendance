package com.shenbaoyong.attendance.pojo;

/**
 * Created by Shen Baoyong on 2017/5/9.
 */
public class CourseListVO {
    private String teacherName;
    private String classroomName;
    private String courseName;
    private String courseTimeId;
    private int dayOfWeek;
    private int courseSchedulId;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTimeId() {
        return courseTimeId;
    }

    public void setCourseTimeId(String courseTimeId) {
        this.courseTimeId = courseTimeId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getCourseSchedulId() {
        return courseSchedulId;
    }

    public void setCourseSchedulId(int courseSchedulId) {
        this.courseSchedulId = courseSchedulId;
    }
}
