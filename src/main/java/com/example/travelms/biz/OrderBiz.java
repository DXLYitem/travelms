package com.example.travelms.biz;
import com.example.travelms.entity.Order;
import com.example.travelms.util.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单Biz
 */
public interface OrderBiz {
    Pages<Order> listOrder(Order order, Integer pageIndex, Integer pageSize);

    Pages<Order> order( Integer pageIndex, Integer pageSize);

    Boolean updateOrder( String ispayment,Integer customizeid);

    List<Order> getOrder(Order order);

    Order selectOrder2(Integer orderId);

    Boolean update(Order order);

    Boolean updateStatus( String status,Integer itemid);
}
