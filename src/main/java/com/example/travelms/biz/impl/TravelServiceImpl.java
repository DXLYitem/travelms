package com.example.travelms.biz.impl;

import com.example.travelms.biz.TravelService;
import com.example.travelms.dao.TravelDao;
import com.example.travelms.entity.Travel;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private TravelDao travelDao;



    @Override
    public List<Travel> listTravel() {
        String trKey="trKey";
        if(redisUtil.exists(trKey)){
            Object o = redisUtil.lRange(trKey, 0, redisUtil.length(trKey)).get(0);
            return (List<Travel>) o;
        }else{
            List<Travel> list=travelDao.selectTravel();
            redisUtil.lPush(trKey,list);
            return list;
        }
    }
}
