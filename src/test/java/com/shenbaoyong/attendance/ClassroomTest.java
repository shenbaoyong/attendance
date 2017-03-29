package com.shenbaoyong.attendance;

import com.shenbaoyong.attendance.dto.BootStrapTableResult;
import com.shenbaoyong.attendance.pojo.Classroom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AttendanceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClassroomTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Test
    public void testClassroomList(){
        String url = "/classroom/list?offset=2&limit=3";
//        BootStrapTableResult<Classroom> result = restTemplate.getForObject(url, BootStrapTableResult.class);
        String result = restTemplate.getForObject(url, String.class);
        System.err.println("返回结果result ： " + result);
        Assert.assertNotNull(result);
    }
}
