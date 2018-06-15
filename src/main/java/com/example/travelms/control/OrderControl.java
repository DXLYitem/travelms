package com.example.travelms.control;
import com.example.travelms.biz.CustomizeService;
import com.example.travelms.biz.OrderBiz;
import com.example.travelms.biz.UserBiz;
import com.example.travelms.entity.Customize;
import com.example.travelms.entity.Item;
import com.example.travelms.entity.Order;
import com.example.travelms.util.Pages;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单管理控制
 */
@Controller
public class OrderControl {
    @Resource
    private OrderBiz orderBiz;

    @Resource
    private CustomizeService customizeService;

    @Resource
    private UserBiz userBiz;

    @RequestMapping("ordercontrol")
    @ResponseBody
    public Pages<Order> continen(Order order, Integer pageIndex, Integer pageSize) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Pages<Order> pageItem=orderBiz.listOrder(order, pageIndex,5);
        Pages<Order> pageItemList=new Pages<>();
        if(pageItem.getList().size()>0){
            for (int i=0;i<pageItem.getList().size();i++){
               /* //得到时间
                Date orderTime=pageItem.getList().get(i).getOrderTime();
                //转换为String类型
                String dateString= formatter.format(orderTime);
                pageItem.getList().get(i).setDate(dateString);*/

               Order o=new Order();
                o.setItemid(pageItem.getList().get(i).getItemid());
                List<Order> list=orderBiz.getOrder(o);
                //比较时间，是否是已消费的
                Date date=new Date();
                if(list.size()>0 && list.get(0).getEndTime().getTime()<date.getTime()){

                    //修改已消费，未消费
                    Boolean aBoolean = orderBiz.updateStatus(list.get(0).getStatus(),list.get(0).getItemid());

                    if(aBoolean==true){
                        Customize cu = customizeService.selectUserName(list.get(0).getCustomizeid());
                        //修改积分
                        userBiz.updateScores(list.get(0).getPrice(),cu.getPhone());
                        //修改已支付，未支付
                        orderBiz.updateOrder("已支付", list.get(0).getCustomizeid());

                    }
                }
            }
        }
        pageItemList=orderBiz.listOrder(order, pageIndex,5);
        for (int i=0;i<pageItemList.getList().size();i++) {
            //得到时间
            Date orderTime = pageItemList.getList().get(i).getOrderTime();
            //转换为String类型
            String dateString = formatter.format(orderTime);
            pageItemList.getList().get(i).setDate(dateString);
        }
        return pageItemList;
    }

    @RequestMapping("updateIspayment")
    @ResponseBody
    public Pages<Order> updateIspayment(Integer customizeid,Integer price,String ispayment,Order order){
        Pages<Order> pageItem = new Pages<Order>();
        if(ispayment.equals("未支付")) {
            Customize cu = customizeService.selectUserName(customizeid);
            if (userBiz.updateScores(price, cu.getPhone()) > 0) {
                if (orderBiz.updateOrder("已支付", customizeid)) {
                    pageItem = orderBiz.order(1, 5);
                    return pageItem;
                }

            }
        }
        return pageItem;
    }

    @RequestMapping("updateOrder")
    public String updateOrder(Model model,Integer orderId){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Order o=orderBiz.selectOrder2(orderId);
        model.addAttribute("order",o);
        String dateString= formatter.format(o.getOrderTime());
        o.setDate(dateString);
        return  "Order_update2";
    }


    @RequestMapping("updateOrderByorderId")
    @ResponseBody
    public String   update(Order order){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Pages<Order> pageItemList=new Pages<>();
        order.setIspayment("未支付");
        /*if(orderBiz.update(order)){
            pageItemList=orderBiz.listOrder(order, 1,5);
            for (int i=0;i<pageItemList.getList().size();i++) {
                //得到时间
                Date orderTime = pageItemList.getList().get(i).getOrderTime();
                //转换为String类型
                String dateString = formatter.format(orderTime);
                pageItemList.getList().get(i).setDate(dateString);
            }
        }*/

        if(orderBiz.update(order)){
            return "true";
        }else{
            return  "false";
        }

    }
}
