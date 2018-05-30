package com.example.travelms.biz;

import com.example.travelms.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemBiz {
    public List<Item>listItem(Item item,Integer pageIndex,Integer pageSize);

    public Integer count(Item item);
}
