package com.example.travelms.biz.impl;

import com.example.travelms.biz.UserBiz;
import com.example.travelms.dao.UserDao;
import com.example.travelms.entity.User;
import com.example.travelms.util.Pages;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBizImpl implements UserBiz{
    @Resource
    private UserDao userDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<User> listUser(User user, Integer pageIndex, Integer pageSize) {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        if(pageSize==null || pageSize==0){
            pageSize=5;
        }
        Pages<User>page=new Pages<User>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(userDao.userCount());
        page.setList(userDao.selectUser(user,(pageIndex-1)*pageSize,pageSize));
        return page;
    }
}
