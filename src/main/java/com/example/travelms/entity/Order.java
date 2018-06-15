package com.example.travelms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer orderId;
    //订单号
    private String orderNum;
    //下单时间
    private Date orderTime;
    //订单金额
    private Integer price;
    //目的地
    private String destination;
    //订单状态
    private String status;
    //私人订制id
    private int customizeid;
  /*  //用户
    private Associator user;*/
    //出发城市
    private String city;

    private Integer itemid;
    //旅游项目名
    private String itemname;
    //房间数
    private Integer roomnum;

    private String time;

    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    /* private Customize customize;*/

    private Integer pageNo;

    private Integer pageSize;

    private Integer totalmoney;

    private String ispayment;
    private String date;
    private String pricem;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomizeid() {
        return customizeid;
    }

    public void setCustomizeid(int customizeid) {
        this.customizeid = customizeid;
    }

 /*   public Customize getCustomize() {
        return customize;
    }

    public void setCustomize(Customize customize) {
        this.customize = customize;
    }*/

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /*public Associator getUser() {
        return user;
    }

    public void setUser(Associator user) {
        this.user = user;
    }*/

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Integer totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getIspayment() {
        return ispayment;
    }

    public void setIspayment(String ispayment) {
        this.ispayment = ispayment;
    }

    public String getPricem() {
        return pricem;
    }

    public void setPricem(String pricem) {
        this.pricem = pricem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                ", status='" + status + '\'' +
                ", customizeid=" + customizeid +
                '}';
    }
}
