package com.example.travelms.dao;

import com.example.travelms.entity.Continent;
import com.example.travelms.entity.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelDao {
    List<Hotel> selectHotel(@Param("hotel")Hotel hotel, @Param("pageIndex")Integer pageIndex, @Param("pageSize") Integer pageSize);
    Integer count(@Param("hotel") Hotel hotel);
    Integer deleteHotel(Integer [] hotelId);
    int insertHotel(@Param("hotel") Hotel hotel);
    int updateByHotel(@Param("hotel") Hotel hotel);
}
