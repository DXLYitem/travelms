package com.example.travelms.biz;

import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;

import java.util.List;

public interface CountryBiz {
    public Pages<Country> listCountry(Country country, Integer pageIndex, Integer pageSize);

    int remove(Integer countryId);
}

