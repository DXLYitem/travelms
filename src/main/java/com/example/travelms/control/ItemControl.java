package com.example.travelms.control;
import com.example.travelms.biz.*;
import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ItemControl {
    @Resource
    private ItemBiz itemBiz;

    @Resource
    private HobbyService hobbyService;

    @Resource
    private TravelService travelService;

    @Resource
    private TrafficService trafficService;

    @Resource
    private StyleService styleService;

    @Resource
    private  BrandService brandService;


    @RequestMapping("item")
    @ResponseBody
    public Pages<Item> listItem(Item item,Integer pageIndex,Integer pageSize){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Pages<Item> pageItem=itemBiz.listItem(item, pageIndex,5);
        if(pageItem.getList().size()>0){
            for (int i=0;i<pageItem.getList().size();i++){
                String dateString= formatter.format(pageItem.getList().get(i).getStartTime());
                pageItem.getList().get(i).setDate(dateString);
            }
        }
        return pageItem;
    }

   @RequestMapping("updateItem")
    public String update(){
       System.out.println(111);
        return  "data_management_look";
    }

    @RequestMapping("showInsertItem")
    public String showInsertItem(Model model){
        //偏好
       model.addAttribute("hobbyList",hobbyService.listHobby());
        //旅行主题
       model.addAttribute("travelList",travelService.listTravel());
       //交通工具
        model.addAttribute("trafficList",trafficService.listTraffic());
        //旅行方式
        model.addAttribute("styleList",styleService.listStyle());
        //酒店品牌
        model.addAttribute("brandList",brandService.listBrand());
        return  "Warning_management_add";
    }

    @RequestMapping("insertItem")
    public String  insertItem(){
        System.out.println(111);
        return "redirect:item";
    }
}
