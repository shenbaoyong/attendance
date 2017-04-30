package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.pojo.Semester;
import com.shenbaoyong.attendance.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/30.
 */
@Controller
@RequestMapping("/admin/semester")
public class SemesterController {

    @Autowired
    ISemesterService semesterService;

    @GetMapping("list")
    public String semesterList(Model model){
        List<Semester> semesters = semesterService.getSemesterList();
        model.addAttribute("semesters", semesters);
        return "semester";
    }

    @GetMapping("add")
    public String addSemester(LocalDate startData, Model model){
        DayOfWeek dayOfWeek = startData.getDayOfWeek();
        if(dayOfWeek.getValue() != 1){
            model.addAttribute("err", "这一天必须是周一");
            return "semesteradd";
        }
        Semester semester = new Semester();
        semester.setStartData(startData);
        semester.setEndData(startData.plusDays(18 * 7));
        semesterService.addSemester(semester);

        List<Semester> semesters = semesterService.getSemesterList();
        model.addAttribute("semesters", semesters);
        return "semester";
    }

    @GetMapping("delete")
    public String deleteSemesterList(String id, Model model){
        Integer idd = Integer.parseInt(id);
        semesterService.deleteSemester( idd );

        List<Semester> semesters = semesterService.getSemesterList();
        model.addAttribute("semesters", semesters);
        return "semester";
    }

}
