package com.example.travelms.biz;

import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemBiz {
    public Pages<Item> listItem(Item item, Integer pageIndex, Integer pageSize);

    public Boolean insertItem(Item item);

    public Boolean deleteItem(Integer [] itemId);
}
