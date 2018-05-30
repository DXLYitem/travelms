package com.example.travelms.biz.impl;

import com.example.travelms.biz.ItemBiz;
import com.example.travelms.dao.ItemDao;
import com.example.travelms.entity.Item;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemBizImpl implements ItemBiz {
    @Resource
    private ItemDao itemDao;

    @Override
    public List<Item> listItem(Item item) {

        return itemDao.selectItem(item);
    }
}
