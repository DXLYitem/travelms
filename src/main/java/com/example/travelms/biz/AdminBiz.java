package com.example.travelms.biz;

import com.example.travelms.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminBiz {
    Admin getAdmin(Admin admin);

    public Boolean updateAdmin(String name,String pwd);

    Admin selectAdminById(@Param("id")Integer id);

    Boolean update(@Param("admin") Admin admin);
}
