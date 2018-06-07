package com.example.travelms.biz.impl;

import com.example.travelms.biz.TrafficService;
import com.example.travelms.dao.TrafficDao;
import com.example.travelms.entity.Traffic;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrafficServiceImpl implements TrafficService {
    @Resource
    private TrafficDao trafficDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Traffic> listTraffic() {
        String trafficKey="trafficKey";
        if(redisUtil.exists(trafficKey)){
            Object o = redisUtil.lRange(trafficKey, 0, redisUtil.length(trafficKey)).get(0);
            return (List<Traffic>) o;
        }else{
            List<Traffic> list=trafficDao.selectTraffic();
            redisUtil.lPush(trafficKey,list);
            return list;
        }

    }
}
