package com.example.travelms.control;

import com.example.travelms.biz.AdminBiz;
import com.example.travelms.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginControl {
    @Resource
    private AdminBiz adminBiz;


    @RequestMapping("login")
    public String login(){

        return "/login";
    }

    @RequestMapping("doLogin")
    public String doLogin(HttpSession session, Admin admin){
        if(admin.getName()!=null && admin.getPwd()!=null){
            Admin a=adminBiz.getAdmin(admin);
            if(a!=null){
                session.setAttribute("admin",a);
                return  "index";
            }else{

            }
        }
        return "redirect:login";
    }

    @RequestMapping("About_us")
    public String about(){
        return "About_us";
    }
    @RequestMapping("Data_management")
    public String data_management(){
        return "Data_management";
    }
    @RequestMapping("Continen_management")
    public String home_add(){
        return "Continen_management";
    }
    @RequestMapping("home_edit")
    public String home_edit(){
        return "home_edit";
    }
    @RequestMapping("Oder_management")
    public String oder_management(){
        return "Oder_management";
    }

}
