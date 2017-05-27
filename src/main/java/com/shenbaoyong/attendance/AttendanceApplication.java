package com.shenbaoyong.attendance;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.pojo.CourseListVO;
import com.shenbaoyong.attendance.service.IStudentUserService;
import com.shenbaoyong.attendance.service.ITeacherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ComponentScan
@Controller
@SpringBootApplication
public class AttendanceApplication {
	static Logger logger = LoggerFactory.getLogger(AttendanceApplication.class);
	@Autowired
	private SessionComponent sessionComponent;
	@Autowired
	IStudentUserService studentUserService;
	@Autowired
	ITeacherUserService teacherUserService;

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
		logger.info("------------AttendanceApplication启动成功---------------");
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
	}

	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model){
		LoginUser loginUser = sessionComponent.getLoginUser();
		if(loginUser == null){
			return "index";
		}else {
			if(loginUser.hasAdminUser()){

			}else if(loginUser.hasStudentUser()){
				List<CourseListVO> courseListVOList = studentUserService.getCourseListOfStudent(1304030221L);
				model.addAttribute("courseList", courseListVOList);
				return "studentCourseList";
			}else if(loginUser.hasTeacherUser()){
				List<CourseListVO> courseListVOList = teacherUserService.getCourseListOfTeacher(1304030221L);
				model.addAttribute("courseList", courseListVOList);
				return "teacherCourseList";
			}
		}
		return "index";
	}
}
