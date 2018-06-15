package com.example.travelms.dao;

import com.example.travelms.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin selectAdmin(Admin admin);

    Integer updateAdmin(@Param("name")String name,@Param("pwd")String pwd);

    Admin selectAdminById(@Param("id")Integer id);

    Integer update(@Param("admin") Admin admin);
}
