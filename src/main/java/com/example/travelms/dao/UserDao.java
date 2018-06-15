package com.example.travelms.dao;

import com.example.travelms.entity.Country;
import com.example.travelms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
  /**
   * 会员管理查询
   * @return
   */
    public List<User> selectUser(@Param("user")User user, @Param("pageIndex")Integer pageIndex, @Param("pageSize") Integer pageSize);
  /**
   * 会员管理总条数
   * @return
   */
  int userCount(@Param("user")User user);

  public Integer updateScores(@Param("scores") Integer scores,@Param("phone")String  phone);


}
