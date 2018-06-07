package com.example.travelms.dao;

import com.example.travelms.entity.Style;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StyleDao {

    public List<Style> selectStyle();
}
