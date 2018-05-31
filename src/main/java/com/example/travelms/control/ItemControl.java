package com.example.travelms.control;
import com.example.travelms.biz.ItemBiz;
import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ItemControl {
    @Resource
    private ItemBiz itemBiz;

    @RequestMapping("item")
    @ResponseBody
    public Pages<Item> listItem(Item item,Integer pageIndex,Integer pageSize){
        Pages<Item> pageItem=itemBiz.listItem(item, pageIndex,5);
        return pageItem;
    }

   @RequestMapping("updateItem")
    public String update(){
       System.out.println(111);
        return  "data_management_look";
    }

    @RequestMapping("insertItem")
    public String insert(){
        System.out.println(111);
        return  "Warning_management_add";
    }
}
