package com.example.travelms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 旅游项目表
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer itemId;
    //地区ID
    private Integer countryId;
    //标题
    private String title;
    //说明
    private String explain;
    //游玩时间
    private String playTime;
    //价格
    private Double price;
    //出发时间
    private Date startTime;
    //出发城市
    private String city;
    //起价说明
    private String priceDesc;
    //详细ID
    private Integer detailId;
    //偏好ID
    private Integer hobbyId;
    //旅行主题ID
    private Integer travelId;
    //交通ID
    private Integer trafficId;
    //旅行方式ID
    private Integer styleId;


   //酒店名
    private  String brandName;
    //地区名
    private  String countryName;
    //地域名
    private  String continentName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    private Integer continentId;

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPriceDesc() {
        return priceDesc;
    }

    public void setPriceDesc(String priceDesc) {
        this.priceDesc = priceDesc;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Integer trafficId) {
        this.trafficId = trafficId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", countryId=" + countryId +
                ", title='" + title + '\'' +
                ", explain='" + explain + '\'' +
                ", playTime='" + playTime + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", city='" + city + '\'' +
                ", priceDesc='" + priceDesc + '\'' +
                ", detailId=" + detailId +
                ", hobbyId=" + hobbyId +
                ", travelId=" + travelId +
                ", trafficId=" + trafficId +
                ", styleId=" + styleId ;

    }
}
