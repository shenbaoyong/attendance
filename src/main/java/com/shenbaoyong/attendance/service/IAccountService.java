package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.dto.BaseResult;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public interface IAccountService {
    BaseResult login(String userType, long userId, String password);
    BaseResult logout();
}
