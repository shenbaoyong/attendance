package com.shenbaoyong.attendance.controller;

import com.shenbaoyong.attendance.common.component.SessionComponent;
import com.shenbaoyong.attendance.common.constents.UserConstants;
import com.shenbaoyong.attendance.dto.BaseResult;
import com.shenbaoyong.attendance.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    SessionComponent sessionComponent;
    @Autowired
    IAccountService accountService;

    @PostMapping("/login")
    public BaseResult login(@RequestBody Map<String, Object> params){
        try{
            String userType = (String)params.get(UserConstants.USER_TYPE);
            long id = Long.parseLong( (String)params.get(UserConstants.USER_ID));
            String password = (String)params.get(UserConstants.USER_PASSWORD);

            BaseResult result = accountService.login(userType, id, password);
            return result;
        }catch (Exception e){
            logger.error("登陆失败",e);
            return BaseResult.error("登陆失败");
        }
    }

    @GetMapping("/logout")
    public BaseResult logout(){
        try {
            BaseResult result = accountService.logout();
            return result;
        }catch (Exception e){
            logger.error("退出失败",e);
            return BaseResult.error("退出失败");
        }
    }


}
