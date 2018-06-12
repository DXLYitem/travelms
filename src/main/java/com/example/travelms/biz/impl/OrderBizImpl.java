package com.example.travelms.biz.impl;

import com.example.travelms.biz.OrderBiz;
import com.example.travelms.dao.OrderDao;
import com.example.travelms.dao.UserDao;
import com.example.travelms.entity.Order;
import com.example.travelms.entity.User;
import com.example.travelms.util.Pages;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单管理Impl
 */
@Service
public class OrderBizImpl implements OrderBiz{
    @Resource
    private OrderDao orderDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<Order> listOrder(Order order, Integer pageIndex, Integer pageSize) {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        if(pageSize==null || pageSize==0){
            pageSize=1;
        }
        Pages<Order>page=new Pages<Order>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(orderDao.orderCount(order));
        page.setList(orderDao.selectOrder(order,(pageIndex-1)*pageSize,pageSize));
        return page;
    }
}
