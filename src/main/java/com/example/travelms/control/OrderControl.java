package com.example.travelms.control;
import com.example.travelms.biz.OrderBiz;
import com.example.travelms.entity.Order;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * 订单管理控制
 */
@Controller
public class OrderControl {
    @Resource
    private OrderBiz orderBiz;
    //查询地域分页
    @RequestMapping("ordercontrol")
    @ResponseBody
    public Pages<Order> continen(Order order, Integer pageIndex, Integer pageSize) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Pages<Order> pageItem=orderBiz.listOrder(order, pageIndex,5);
        if(pageItem.getList().size()>0){
            for (int i=0;i<pageItem.getList().size();i++){
                String dateString= formatter.format(pageItem.getList().get(i).getOrderTime());
                pageItem.getList().get(i).setDate(dateString);
            }
        }
        return pageItem;
    }
}
