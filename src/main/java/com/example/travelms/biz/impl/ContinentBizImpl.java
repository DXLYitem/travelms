package com.example.travelms.biz.impl;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.dao.ContinentDao;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import com.example.travelms.util.RedisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地域表Impl
 */
@Service
public class ContinentBizImpl implements ContinentBiz {
    @Resource
    private ContinentDao continentDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<Continent> listContinent(Continent continent, Integer pageIndex, Integer pageSize) {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        Pages<Continent>page=new Pages<Continent>();
       page.setPageIndex(pageIndex);
       page.setPageSize(pageSize);
       page.setTotalCount(continentDao.continentCount());
       page.setList(continentDao.selectContinent(continent,(pageIndex-1)*pageSize,pageSize));
       return page;
    }

    @Override
    public int updateBycontId(Continent continent) {

        return continentDao.updateBycontinentId(continent);
    }

    @Override
    public int delBycontId(Integer continentId) {
        String conKey="conKey";

        if(redisUtil.exists(conKey)){
            Object o = redisUtil.lRange(conKey, 0, redisUtil.length(conKey)).get(0);
            return (int) o;
        }else{

           int num=continentDao.deleteBycontinentId(continentId);

            redisUtil.lPush(conKey,num);
            return num;
        }

    }
}
