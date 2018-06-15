package com.example.travelms.biz;


import com.example.travelms.entity.Customize;
import org.apache.ibatis.annotations.Param;

public interface CustomizeService {
    Customize selectUserName(Integer customizeId);
}
