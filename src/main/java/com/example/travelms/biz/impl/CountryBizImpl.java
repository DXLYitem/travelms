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
        Integer num = countryDao.count(country);
        Pages<Country> page = new Pages<Country>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(countryDao.count(country));
        page.setList(countryDao.selectPageByCountry(country, (pageIndex - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public Boolean add(Country country) {
        String couKey="couKey"+country.getCountryId();
        if(redisUtil.exists(couKey)) {
            redisUtil.remove(couKey);
        }
        if(countryDao.insert(country)>0){
            return  true;
        }else{
            return false;
        }
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

    @Override
    public int modify(Country country) {
        String couKey = "couKey" + country.getCountryId();
        if (redisUtil.exists(couKey)) {
            redisUtil.remove(couKey);
        }
        return countryDao.update(country);
    }

    @Override
    public Boolean removeAll(Integer[] countryId) {
        /*String couKey="couKey"+countryId;
        if(redisUtil.exists(couKey)) {
            redisUtil.remove(couKey);
        }*/
        if (countryDao.deleteAll(countryId) > 0) {
            return true;
        } else {
            return false;
        }
    }

}
