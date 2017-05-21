package com.shenbaoyong.attendance.pojo;

public class CourseSchedul {
    private Integer id;

    private Integer classId;

    private Integer courseId;

    private Integer semesterId;

    private String courseTimeId;

    private Integer dayOfWeek;

    private Integer teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}