package com.shenbaoyong.attendance.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Baoyong on 2017/4/15.
 */
@Component
public class Receiver {

    @KafkaListener(topics = "test1")
    public void process(String content){
        System.out.println("receive " + content);
    }
}
