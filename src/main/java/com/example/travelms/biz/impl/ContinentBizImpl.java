package com.example.travelms.biz.impl;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.dao.ContinentDao;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import com.example.travelms.util.RedisUtil;
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
       /* if(pageSize==null || pageSize==0){
            pageSize=5;
        }*/
        Pages<Continent>page=new Pages<Continent>();
       page.setPageIndex(pageIndex);
       page.setPageSize(pageSize);
       page.setTotalCount(continentDao.continentCount(continent));
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
    public boolean delBycontId(Integer [] continentId) {
        String conKey="conKey"+continentId;
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return continentDao.deleteBycontinentId(continentId)>0;
        }

    @Override
    public int addContinent(Continent continent) {
        String conKey="conKey"+continent.getContinentId();
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return continentDao.insertContinent(continent);

    }

    @Override
    public List<Continent> listExcelController() {

        return continentDao.selectExcelContinent();
    }


    @Override
    public List<Continent> listContinent() {
        String conKey = "conKey";

        if (redisUtil.exists(conKey)) {
            Object o = redisUtil.lRange(conKey, 0, redisUtil.length(conKey)).get(0);
            return (List<Continent>) o;
        } else {
            List<Continent> list = continentDao.selectContinentTwo();
            redisUtil.lPush(conKey, list);
            return list;
        }
    }
}
