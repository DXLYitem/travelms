package com.example.travelms.biz.impl;

import com.example.travelms.biz.CountryBiz;
import com.example.travelms.dao.CountryDao;
import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Service;
import com.example.travelms.util.RedisUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryBizImpl implements CountryBiz{
    @Resource
    private CountryDao countryDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<Country> listPageCountry(Country country, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex == 0) {
            pageIndex = 1;
        }
        Integer num = countryDao.count();
        Pages<Country> page = new Pages<Country>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(countryDao.count());
        page.setList(countryDao.selectPageByCountry(country, (pageIndex - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public int remove(Integer countryId) {
        String couKey="couKey";
        if(redisUtil.exists(couKey)) {
            redisUtil.remove(couKey);
        }
        int num=countryDao.delete(countryId);
        return num;
    }

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
