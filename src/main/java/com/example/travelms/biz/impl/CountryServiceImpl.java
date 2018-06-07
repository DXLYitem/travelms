package com.example.travelms.biz.impl;

import com.example.travelms.biz.CountryService;
import com.example.travelms.dao.CountryDao;
import com.example.travelms.entity.Country;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private CountryDao countryDao;

    @Override
    public List<Country> listCountry(Integer continentId) {
        String couKey="couKey"+continentId;
        /*redisUtil.remove(couKey);*/
        if(redisUtil.exists(couKey)){
            Object o = redisUtil.lRange(couKey, 0, redisUtil.length(couKey)).get(0);
            return (List<Country>) o;
        }else{
             List<Country> list=countryDao.selectCountry(continentId);
             redisUtil.lPush(couKey,list);
             return list;
        }


    }
}
