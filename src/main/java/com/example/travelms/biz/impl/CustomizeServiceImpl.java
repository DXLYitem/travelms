package com.example.travelms.biz.impl;

import com.example.travelms.biz.CustomizeService;
import com.example.travelms.dao.CustomizeDao;
import com.example.travelms.entity.Customize;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomizeServiceImpl implements CustomizeService {

    @Resource
    private CustomizeDao customizeDao;

    @Override
    public Customize selectUserName(Integer customizeId) {

        return customizeDao.selectUserName(customizeId);
    }
}
