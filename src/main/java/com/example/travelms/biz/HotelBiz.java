package com.example.travelms.biz;

import com.example.travelms.entity.Hotel;
import com.example.travelms.util.Pages;

public interface HotelBiz {
    public Pages<Hotel> listHotel(Hotel hotel, Integer pageIndex, Integer pageSize);
}
