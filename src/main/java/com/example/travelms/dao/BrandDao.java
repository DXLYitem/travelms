package com.example.travelms.dao;

import com.example.travelms.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {
    /**
     * 根据度假ID查询度假套餐表下面的酒店品牌
     * @param
     * @return
     */
    List<Brand> selectBrand();
}
