package com.example.travelms.dao;


import com.example.travelms.entity.Traffic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrafficDao {

    public List<Traffic> selectTraffic();
}
