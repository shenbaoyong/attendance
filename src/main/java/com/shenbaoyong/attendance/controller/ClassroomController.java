package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.dto.BootStrapTableResult;
import com.shenbaoyong.attendance.pojo.Classroom;
import com.shenbaoyong.attendance.service.IClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Baoyong Shen on 2017/3/15.
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @Autowired
    IClassroomService classroomService;

    @GetMapping(value = "/list",produces = "application/json;charset=UTF-8")
    public BootStrapTableResult<Classroom> list( Integer offset, Integer limit){
        try{
            logger.info("------------request :  /classroom/list-------");
            //System.out.println("------------request :  /classroom/list---------------");
            //offset = offset == null ? 0 : offset;
            //limit = limit == null ? 2 : limit;
            List<Classroom> classroomList = classroomService.getClassroomList();
            return new BootStrapTableResult<Classroom>(classroomList);
        }catch (Exception e){
            e.printStackTrace();
            return new BootStrapTableResult<>(null);
        }

    }
}
