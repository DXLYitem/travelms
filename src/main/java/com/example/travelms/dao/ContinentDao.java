package com.example.travelms.dao;

import com.example.travelms.entity.Continent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地域表Dao
 */
public interface ContinentDao {
    /**
     * 地域表查询
     * @return
     */
    List<Continent>selectContinent(@Param("con") Continent con, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 地域表总条数
     * @return
     */
    int continentCount();

    /**
     * 修改地域表
     * @return
     */
    int updateBycontinentId(@Param("continent") Continent continent);
    /**
     *根据Id删除地域
     */
    int deleteBycontinentId(@Param("continentId") Integer continentId);
    /**
     * 添加地域
     */
    int insertContinent(Continent continent);
}
