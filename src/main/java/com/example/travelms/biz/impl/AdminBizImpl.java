package com.example.travelms.biz.impl;

import com.example.travelms.biz.AdminBiz;
import com.example.travelms.dao.AdminDao;
import com.example.travelms.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminBizImpl implements AdminBiz {
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin getAdmin(Admin admin) {


        return adminDao.selectAdmin(admin);
    }
}
