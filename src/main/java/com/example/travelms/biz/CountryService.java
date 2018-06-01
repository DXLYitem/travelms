package com.example.travelms.biz;

import com.example.travelms.entity.Country;

import java.util.List;

public interface CountryService {

    public List<Country> listCountry(Integer continentId);
}
