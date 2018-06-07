package com.example.travelms.biz;

import com.example.travelms.entity.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 根据度假ID查询度假套餐表下面的酒店品牌
     * @param holidayId
     * @return
     */
    public List<Brand> listBrand();
}
