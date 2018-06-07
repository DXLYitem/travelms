package com.example.travelms.dao;

import com.example.travelms.entity.Hobby;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HobbyDao {

    public List<Hobby> selectHobby();
}
