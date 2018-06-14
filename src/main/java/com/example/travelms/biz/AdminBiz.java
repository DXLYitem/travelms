package com.example.travelms.biz;

import com.example.travelms.entity.Admin;

public interface AdminBiz {
    Admin getAdmin(Admin admin);

    public Boolean updateAdmin(String name,String pwd);
}
