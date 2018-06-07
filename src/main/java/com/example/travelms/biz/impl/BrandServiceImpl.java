package com.example.travelms.biz.impl;

import com.example.travelms.biz.BrandService;
import com.example.travelms.dao.BrandDao;
import com.example.travelms.entity.Brand;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Brand> listBrand() {
        String brKey="brKey";
        //判断redis缓存里键为con集合是否存在
        if(redisUtil.exists(brKey)){
            Object o = redisUtil.lRange(brKey, 0, redisUtil.length(brKey)).get(0);
            return (List<Brand>) o;
        }else{
            //查询酒店
            List<Brand> list=brandDao.selectBrand();
            //把键为conKey值为list集合缓存到redis
            redisUtil.lPush(brKey,list);
            return list;
        }

    }
}
