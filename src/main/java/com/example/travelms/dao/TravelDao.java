package com.example.travelms.dao;

import com.example.travelms.entity.Travel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelDao {

    public List<Travel> selectTravel();
}
