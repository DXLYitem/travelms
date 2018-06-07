package com.example.travelms.biz;
import com.example.travelms.entity.Order;
import com.example.travelms.util.Pages;

/**
 * 订单Biz
 */
public interface OrderBiz {
    Pages<Order> listOrder(Order order, Integer pageIndex, Integer pageSize);

}
