package com.example.travelms.dao;

import com.example.travelms.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDao {

    public List<Item> selectItem(@Param("item")Item item,@Param("pageIndex")Integer pageIndex,@Param("pageSize") Integer pageSize);

    public Integer count(@Param("item")Item item);

    public Integer insertItem(@Param("item")Item item);

    public Integer deleteItem(Integer [] itemId);
}
