package com.example.travelms.biz.impl;

import com.example.travelms.biz.HobbyService;
import com.example.travelms.dao.HobbyDao;
import com.example.travelms.entity.Hobby;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {
    @Resource
    private HobbyDao hobbyDao;
    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<Hobby> listHobby() {
       String hoKey="hoKey";
        if(redisUtil.exists(hoKey)){
            Object o = redisUtil.lRange(hoKey, 0, redisUtil.length(hoKey)).get(0);
            return (List<Hobby>) o;
        }else{
            List<Hobby> list=hobbyDao.selectHobby();
            redisUtil.lPush(hoKey,list);
            return list;
        }

    }
}
