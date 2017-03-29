package com.shenbaoyong.attendance.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
public class BootStrapTableResult<T> implements Serializable{

    private static final long serialVersionUID = -4185151304730685014L;

    private List<T> data;

    public BootStrapTableResult(List<T> data) {
        super();
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
