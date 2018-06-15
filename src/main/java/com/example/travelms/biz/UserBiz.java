package com.example.travelms.biz;
import com.example.travelms.entity.User;
import com.example.travelms.util.Pages;
import org.apache.ibatis.annotations.Param;

/**
 *会员管理Biz
 */
public interface UserBiz {
    Pages<User> listUser(User user, Integer pageIndex, Integer pageSize);

    public Integer updateScores(Integer scores,String phone);
}
