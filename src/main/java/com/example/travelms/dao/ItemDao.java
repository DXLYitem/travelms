package com.example.travelms.dao;

import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;

import java.util.List;

public interface ItemDao {

    public List<Item> selectItem(Item item);

    public Integer count(Item item);
}
