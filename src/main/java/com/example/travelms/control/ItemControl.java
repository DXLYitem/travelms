package com.example.travelms.control;
import com.example.travelms.biz.ItemBiz;
import com.example.travelms.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemControl {
    @Resource
    private ItemBiz itemBiz;

    @RequestMapping("item")
    @ResponseBody
    public List<Item> listItem(Item item,Integer pageIndex,Integer pageSize){
       // item.setItemId(1);

        List<Item> itemList=itemBiz.listItem(item, 0,5);
        return itemList;
    }
}
