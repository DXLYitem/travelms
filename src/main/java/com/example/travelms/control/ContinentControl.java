package com.example.travelms.control;
import com.alibaba.fastjson.JSON;
import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 地域列表控制层
 */
@Controller
public class ContinentControl {
    @Resource
    private ContinentBiz continentBiz;
   //查询地域分页
    @RequestMapping("continen")
    @ResponseBody
    public Pages<Continent> continen(Continent con, Integer pageIndex, Integer pageSize){

        Pages<Continent> pageContinent=continentBiz.listContinent(con, pageIndex,5);

     return  pageContinent;
    }
    @RequestMapping("updateContinen")
    public String updateContin(Integer continentId,String continentName){

        Integer a=continentId;
        String c=continentName;

        return  "continen_look";
    }

    @RequestMapping("updateContinen2")
    public String updateContin2(){
        System.out.println(13456);
        return  "redirect:continen";
    }
    @RequestMapping("deleteContinen")
    @ResponseBody
    public int del(Integer continentId){
      return continentBiz.delBycontId(continentId);
    }

   //打开添加页面
    @RequestMapping("insertContinen")
    public String addOpen(){
        return "continen_add.html";
    }
    //添加数据后返回的页面
    @RequestMapping("insertContinen2")
    @ResponseBody
    public Integer addContinen(String continenName, Integer holidayId)throws IOException {
        Continent continent=new Continent();
        continent.setContinentName(continenName);
        continent.setHolidayId(holidayId);
        Integer num=continentBiz.addContinent(continent);

       /* String com=null;
        if(num>0){
            com="添加成功!";
            System.out.println(com);
        }else {
            com="添加失败!";
            System.out.println(com);
        }
        response.getWriter().print(com);*/
         return num;
    }
}
