package com.example.travelms.biz;

import com.example.travelms.entity.Continent;
import com.example.travelms.entity.Country;
import com.example.travelms.entity.Hotel;
import com.example.travelms.util.Pages;

import java.util.List;

public interface HotelBiz {
    public Pages<Hotel> listHotel(Hotel hotel, Integer pageIndex, Integer pageSize);
    boolean delByhotelId(Integer [] hotelId);
    int addHotel(Hotel hotel);
    int updateByHotelId(Hotel hotel);
}
