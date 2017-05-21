package com.shenbaoyong.attendance.pojo;

public class CourseList {
    private String teacherName;

    private String classroomName;

    private String courseName;

    private String courseTimeId;

    private Integer dayOfWeek;

    private Integer courseSchedulId;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTimeId() {
        return courseTimeId;
    }

    public void setCourseTimeId(String courseTimeId) {
        this.courseTimeId = courseTimeId == null ? null : courseTimeId.trim();
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getCourseSchedulId() {
        return courseSchedulId;
    }

    public void setCourseSchedulId(Integer courseSchedulId) {
        this.courseSchedulId = courseSchedulId;
    }
}