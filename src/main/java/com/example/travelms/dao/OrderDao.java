package com.example.travelms.dao;

import com.example.travelms.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单管理
 */
public interface OrderDao {
    /**
     *订单查询
     * @return
     */
    public List<Order> selectOrder(@Param("order")Order order, @Param("pageIndex")Integer pageIndex, @Param("pageSize") Integer pageSize);

    public List<Order> order( @Param("pageIndex")Integer pageIndex, @Param("pageSize") Integer pageSize);
    /**
     * 订单总条数
     * @return
     */
    int orderCount(@Param("order")Order order);

    Integer updateOrder(@Param("ispayment")String ispayment, @Param("customizeid") Integer customizeid);

    List<Order> getOrder(@Param("order")Order order);

    Order selectOrder2(@Param("orderId")Integer orderId);

    Integer update(@Param("order")Order order);

    int updateStatus(@Param("status") String status,@Param("itemid")Integer itemid);
}
