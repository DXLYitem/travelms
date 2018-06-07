package com.example.travelms.biz;

import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryBiz {
    public Pages<Country> listPageCountry(Country country, Integer pageIndex, Integer pageSize);

    int remove(Integer countryId);

    int add(Country country);

    public List<Country> listCountry(Integer continentId);

}

