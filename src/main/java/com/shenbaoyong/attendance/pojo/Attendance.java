package com.shenbaoyong.attendance.pojo;

public class Attendance {
    private Integer id;

    private Integer courseSchedulId;

    private Integer studentId;

    private Integer weekId;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseSchedulId() {
        return courseSchedulId;
    }

    public void setCourseSchedulId(Integer courseSchedulId) {
        this.courseSchedulId = courseSchedulId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}