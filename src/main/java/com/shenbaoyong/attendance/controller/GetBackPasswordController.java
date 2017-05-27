package com.shenbaoyong.attendance.controller;

import com.alibaba.druid.util.StringUtils;
import com.shenbaoyong.attendance.cache.RedisCache;
import com.shenbaoyong.attendance.service.IGebackPasswordService;
import com.shenbaoyong.attendance.service.IStudentUserService;
import org.codehaus.groovy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Created by Shen Baoyong on 2017/5/25.
 */
@Controller
public class GetBackPasswordController {

    @Autowired
    RedisCache redisCache;
    @Autowired
    IGebackPasswordService gebackPasswordService;

    Logger logger = LoggerFactory.getLogger(GetBackPasswordController.class);

    @RequestMapping("/sendCode")
    public String sendCode(@RequestParam String phone, Model model){
        if(StringUtils.isEmpty(phone) || phone.length()!=11){
            model.addAttribute("msg", "手机号不合法");
            return "getBackPassword";
        }
        String origin =String.valueOf(new Random().nextDouble());
        String code = origin.substring(2, origin.length());
        //todo 发送验证码
        if(true){
            logger.info("缓存验证码 手机号" + phone + "  验证码" + code);
            String key = phone;
            //redisCache.putCacheWithExpireTime(key, code, 60);
            redisCache.putCache(key, "666666");
        }
        model.addAttribute("msg", "验证码发送成功");
        return "getBackPassword";
    }

    @RequestMapping("/getbackPassword")
    public String getbackPassword(@RequestParam(required = false) String phone,
                                  @RequestParam(required = false) String code,
                                  @RequestParam(required = false) String newPassword,
                                  Model model){

        if(StringUtils.isEmpty(phone)){
            return "getBackPassword";
        }
        String key = phone;
        String redisCode = redisCache.getCache(key, String.class);
        if(StringUtils.isEmpty(redisCode)){
            model.addAttribute("msg", "验证码已过期");
            return "getBackPassword";
        }else if(!redisCode.equals(code)){
            model.addAttribute("msg", "验证码不正确");
            return "getBackPassword";
        }
        boolean success = gebackPasswordService.getbackPassword(newPassword, phone);
        if(success){
            model.addAttribute("msg", "找回密码成功");
            return "getBackPassword";
        }
        model.addAttribute("msg", "找回密码失败");
        return "getBackPassword";
    }
}
