package com.shenbaoyong.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan
@Controller
@SpringBootApplication
public class AttendanceApplication {
	static Logger logger = LoggerFactory.getLogger(AttendanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
		logger.info("------------AttendanceApplication启动成功---------------");
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
	}

	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
