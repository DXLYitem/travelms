package com.example.travelms.biz.impl;

import com.example.travelms.biz.StyleService;
import com.example.travelms.dao.StyleDao;
import com.example.travelms.entity.Style;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private StyleDao styleDao;


    @Override
    public List<Style> listStyle() {

        String styKey="styKey";
        if(redisUtil.exists(styKey)){
            Object o = redisUtil.lRange(styKey, 0, redisUtil.length(styKey)).get(0);
            return (List<Style>) o;
        }else{
            List<Style> list=styleDao.selectStyle();
            redisUtil.lPush(styKey,list);
            return list;
        }
    }
}
