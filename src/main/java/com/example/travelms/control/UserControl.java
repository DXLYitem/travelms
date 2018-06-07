package com.example.travelms.control;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.biz.UserBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.entity.User;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 会员管理查询
 */
@Controller
public class UserControl {
    @Resource
    private UserBiz userBiz;
    //查询地域分页
    @RequestMapping("usercontrol")
    @ResponseBody
    public Pages<User> continen(User user, Integer pageIndex, Integer pageSize){
        Pages<User> pageContinent=userBiz.listUser(user, pageIndex,pageSize);
        return  pageContinent;
    }
}
