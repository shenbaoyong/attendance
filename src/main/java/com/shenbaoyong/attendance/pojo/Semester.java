package com.shenbaoyong.attendance.pojo;

import org.assertj.core.internal.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class Semester {
    private Integer id;

    private LocalDate startData;

    private LocalDate endData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartData() {
        return startData;
    }

    public void setStartData(LocalDate startData) {
        this.startData = startData;
    }

    public LocalDate getEndData() {
        return endData;
    }

    public void setEndData(LocalDate endData) {
        this.endData = endData;
    }
}