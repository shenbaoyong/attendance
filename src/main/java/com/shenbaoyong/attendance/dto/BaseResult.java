package com.shenbaoyong.attendance.dto;

import com.fasterxml.jackson.databind.deser.Deserializers;

import java.io.Serializable;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
public class BaseResult<T> implements Serializable{

    private static final long serialVersionUID = -4185151304730685014L;

    private boolean success;
    private T data;
    private String error;

    public BaseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BaseResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public static BaseResult ok(Object data){
        return new BaseResult(true, data);
    }

    public static BaseResult error(String error){
        return new BaseResult(false, error);
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseResult [success=" + success + ", data=" + data + ", error=" + error + "]";
    }
}
