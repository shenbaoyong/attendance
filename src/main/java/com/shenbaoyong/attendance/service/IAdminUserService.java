package com.shenbaoyong.attendance.service;

import com.shenbaoyong.attendance.pojo.AdminUser;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public interface IAdminUserService {
    AdminUser getAdminUserById(Long id);
}
