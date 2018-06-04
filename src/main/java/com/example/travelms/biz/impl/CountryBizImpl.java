package com.example.travelms.biz.impl;

import com.example.travelms.biz.CountryBiz;
import com.example.travelms.dao.CountryDao;
import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Service;
import com.example.travelms.util.RedisUtil;

import javax.annotation.Resource;
@Service
public class CountryBizImpl implements CountryBiz{
    @Resource
    private CountryDao countryDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<Country> listCountry(Country country, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex == 0) {
            pageIndex = 1;
        }
        Integer num = countryDao.count();
        Pages<Country> page = new Pages<Country>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(countryDao.count());
        page.setList(countryDao.selectCountry(country, (pageIndex - 1) * pageSize, pageSize));
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
}
