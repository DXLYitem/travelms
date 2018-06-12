package com.example.travelms.dao;

import com.example.travelms.entity.Country;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CountryDao {
    public List<Country> selectPageByCountry(@Param("country")Country country, @Param("pageIndex")Integer pageIndex, @Param("pageSize") Integer pageSize);

    public Integer count(@Param("country")Country country);

    Integer insert(@Param("country")Country country);

    public List<Country> selectCountry(@Param("continentId") Integer continentId);

    int update(@Param("country") Country country);

    Integer deleteAll(Integer [] countryId);
}
