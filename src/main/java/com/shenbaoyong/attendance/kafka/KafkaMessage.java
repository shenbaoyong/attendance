package com.shenbaoyong.attendance.kafka;

import java.time.LocalDate;

/**
 * Created by Shen Baoyong on 2017/4/15.
 */
public class KafkaMessage {
    private Long id;
    private String msg;
    private LocalDate sendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDate getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDate sendTime) {
        this.sendTime = sendTime;
    }
}
