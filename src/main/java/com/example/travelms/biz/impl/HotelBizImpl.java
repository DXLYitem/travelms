package com.example.travelms.biz.impl;

import com.example.travelms.biz.HotelBiz;
import com.example.travelms.dao.HotelDao;
import com.example.travelms.entity.Hotel;
import com.example.travelms.util.Pages;
import com.example.travelms.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HotelBizImpl implements HotelBiz{
    @Resource
    private HotelDao hotelDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public Pages<Hotel> listHotel(Hotel hotel, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex == 0) {
            pageIndex = 1;
        }
        Integer num = hotelDao.count(hotel);
        Pages<Hotel> page = new Pages<Hotel>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(hotelDao.count(hotel));
        page.setList(hotelDao.selectHotel(hotel, (pageIndex - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public boolean delByhotelId(Integer[] hotelId) {
        String conKey="Kedy"+hotelId;
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return hotelDao.deleteHotel(hotelId)>0;
    }
    @Override
    public int addHotel(Hotel hotel) {
        String conKey="Kedy"+hotel.getHotelId();
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }
        return hotelDao.insertHotel(hotel);
    }

    @Override
    public int updateByHotelId(Hotel hotel) {
    /*    String conKey="Kedy"+hotel.getHotelId();
        if(redisUtil.exists(conKey)) {
            redisUtil.remove(conKey);
        }*/
        return hotelDao.updateByHotel(hotel);
    }
}
