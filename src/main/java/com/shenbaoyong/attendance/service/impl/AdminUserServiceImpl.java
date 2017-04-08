package com.shenbaoyong.attendance.service.impl;

import com.shenbaoyong.attendance.dao.AdminUserMapper;
import com.shenbaoyong.attendance.pojo.AdminUser;
import com.shenbaoyong.attendance.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public AdminUser getAdminUserById(Long id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }
}
