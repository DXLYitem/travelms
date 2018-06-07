package com.example.travelms.biz.impl;

import com.example.travelms.biz.ItemBiz;
import com.example.travelms.dao.ItemDao;
import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemBizImpl implements ItemBiz {
    @Resource
    private ItemDao itemDao;

    @Override
    public Boolean deleteItem(Integer[] itemId) {
        if(itemDao.deleteItem(itemId)>0){
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean insertItem(Item item) {
        if(itemDao.insertItem(item)>0){
            return  true;
        }else{
            return false;
        }

    }

    @Override
    public Pages<Item> listItem(Item item, Integer pageIndex, Integer pageSize) {
        if(pageIndex==null || pageIndex==0) {
            pageIndex=1;
        }
        Integer num=itemDao.count(item);
        Pages<Item> page=new Pages<Item>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(itemDao.count(item));
        page.setList(itemDao.selectItem(item,(pageIndex-1)*pageSize,pageSize));

        return page;
    }
}
