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
        if(admin.getName()!="" && admin.getPwd()!=""){
            Admin a=adminBiz.getAdmin(admin);
            if(a!=null){
                session.setAttribute("admin",a);
                return  "index";
            }
        }
       // return"<script> layer.msg('登入失败', {icon: 0});window.location.href='login'</script>"  ;
        return "redirect:login";
    }

    @RequestMapping("updateAdmin")
    @ResponseBody
    public String updateAdmin(String name,String pwd1,String pwd,HttpSession session){
        Admin admin=(Admin) session.getAttribute("admin");

        if(pwd1.equals("") && pwd.equals("")){
            return "null";
        }
        if(pwd.equals(admin.getPwd())){
            return "yiyang";
        }
        if(!pwd1.equals(pwd)){
            return "pwd";
        }
        if(adminBiz.updateAdmin(name,pwd)){
            return "yes";
        }else{
            return "no";
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Admin admin,HttpSession session){
        Admin a=(Admin)session.getAttribute("admin");
        admin.setId(a.getId());
        if( adminBiz.update(admin)){
            return "true";
        }else{
            return "false";
        }

    }



    @RequestMapping("About_us")
    public String about(){
        return "About_us";
    }
    @RequestMapping("Data_management")
    public String data_management(){
        return "Data_management";
    }
    //地域管理页面
    @RequestMapping("Continen_management")
    public String home_add(){
        return "Continen_management";
    }
    @RequestMapping("Country_management")
    public String country_management(){
        return "Country_management";
    }
    //订单管理页面
    @RequestMapping("Order")
    public String oder(){
        return "Order";
    }
    //会员管理页面
    @RequestMapping("UserName_management")
    public String UserName_management() {
        return "UserName_management";
    }
    @RequestMapping("Hotel_management")
    public String hotel_management(){
        return "Hotel_management";
    }

    @RequestMapping("updatePwd")
    public String updatePwd(){
        return "updatePwd";
    }
    @RequestMapping("My_management_edit")
    public String My_management_edit(Model model,HttpSession session){
        Admin a=(Admin)session.getAttribute("admin");
        Admin sss=adminBiz.selectAdminById(a.getId());
        model.addAttribute("a", sss);
        return "My_management_edit";
    }

}
