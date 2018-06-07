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
public class ContinentBizImpl implements ContinentBiz{
    @Resource
    private ContinentDao continentDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Pages<Continent> listContinent(Continent continent, Integer pageIndex, Integer pageSize) {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        if(pageSize==null || pageSize==0){
            pageSize=5;
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
        String conKey="conKey"+continent.getContinentId();
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return continentDao.updateBycontinentId(continent);
    }

    @Override
    public int delBycontId(Integer continentId) {
        String conKey="conKey"+continentId;
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return continentDao.deleteBycontinentId(continentId);
        }

    @Override
    public int addContinent(Continent continent) {
        String conKey="conKey"+continent.getContinentId();
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return continentDao.insertContinent(continent);

    }

}
