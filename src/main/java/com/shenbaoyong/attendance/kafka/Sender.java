package com.shenbaoyong.attendance.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Baoyong on 2017/4/15.
 */
@Component
public class Sender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send() {
        String str = String.valueOf(System.currentTimeMillis());
        System.out.println("send " + str);
        kafkaTemplate.send("test1", str);
        kafkaTemplate.metrics();
    }
}
