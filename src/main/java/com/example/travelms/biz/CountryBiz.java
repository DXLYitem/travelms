package com.example.travelms.biz;

import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryBiz {
    public Pages<Country> listPageCountry(Country country, Integer pageIndex, Integer pageSize);

    Boolean add(Country country);

    int modify(Country country);

    public List<Country> listCountry(Integer continentId);

    Boolean removeAll(Integer [] countryId);

    List<Country>countryList();

}

