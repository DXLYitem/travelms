package com.example.travelms.dao;

import com.example.travelms.entity.Customize;
import org.apache.ibatis.annotations.Param;

public interface CustomizeDao {
    Customize selectUserName(@Param("customizeId")Integer customizeId);
}
