package com.shenbaoyong.attendance.interceptor;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.pojo.LoginUser;
import com.shenbaoyong.attendance.common.utils.JsonUtils;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.pojo.TeacherUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Component
public class AAuthenticationInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AAuthenticationInterceptor.class);

    @Value("${spring.intercepter.enable:true}")
    boolean intercepterEnable = true;

    @Autowired
    SessionComponent sessionComponent;

    public boolean isIntercepterEnable() {
        return intercepterEnable;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (!isIntercepterEnable()) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();

        String sessionId = session.getId();
        logger.info("------------------sessionId:" + sessionId + " -----------------------");
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        logger.info("--------------requestURL:" + requestURL + "--------------");
        String method = httpServletRequest.getMethod();
        logger.info("--------------------------------------method:" + method + "----------------------------------------");

        LoginUser loginUser = sessionComponent.getLoginUser();
        if (loginUser == null) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            String json = JsonUtils.objectToJson(BaseResult.error("请登录"));
            httpServletResponse.getWriter().print(json);
            return false;
        }
        if (loginUser.hasAdminUser()) {
            AdminUser adminUser = loginUser.getAdminUser();
            logger.info("-------------------------------loginUser:" + adminUser.getId() + "--" + adminUser.getName() + "---------------------------");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
