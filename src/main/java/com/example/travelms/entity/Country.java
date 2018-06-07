package com.example.travelms.entity;

import java.io.Serializable;

/**
 * 地区表
 */
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    //地区ID
    private Integer countryId;
    //地区名
    private String countryName;
    //地域ID
    private Integer continentId;

    private String continentName;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", continentId=" + continentId +
                '}';
    }
}
