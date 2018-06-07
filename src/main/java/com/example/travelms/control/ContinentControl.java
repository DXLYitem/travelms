package com.example.travelms.control;
import com.alibaba.fastjson.JSON;
import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import javax.annotation.Resource;
import java.io.IOException;

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
        Pages<Continent> pageContinent=continentBiz.listContinent(con, pageIndex,pageSize);

     return  pageContinent;
    }
    //打开修改页面
    @RequestMapping("updateContinen")
    public String updateContin(Integer continentId,String continentName,Model model){
        model.addAttribute("continentId",continentId);
        model.addAttribute("continentName",continentName);
        return  "continen_look";
    }

    @RequestMapping("updateContinen2")
    @ResponseBody
    public int updateContin2(Integer continentId,String continentName){
        Continent continent=new Continent();
        continent.setContinentId(continentId);
        continent.setContinentName(continentName);
       /* continent.setHolidayId(2);*/
        return  continentBiz.updateBycontId(continent);
    }
    //删除地域
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

         return num;
    }
}
