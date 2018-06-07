package com.example.travelms.control;

import com.example.travelms.biz.HotelBiz;
import com.example.travelms.entity.Hotel;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HotelControl {
    @Resource
    private HotelBiz hotelBiz;

    @RequestMapping("hotel")
    @ResponseBody
    public Pages<Hotel> listHotel(Hotel hotel, Integer pageIndex, Integer pageSize){
        Pages<Hotel> pageCountry=hotelBiz.listHotel(hotel, pageIndex,1);
        return pageCountry;
    }
}
