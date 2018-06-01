package com.example.travelms.control;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 地域列表控制层
 */
@Controller
public class ContinentControl {
    @Resource
    private ContinentBiz continentBiz;

    @RequestMapping("continen")
    @ResponseBody
    public Pages<Continent> continen(Continent con, Integer pageIndex, Integer pageSize){

        Pages<Continent> pageContinent=continentBiz.listContinent(con, pageIndex,5);

     return  pageContinent;
    }
    @RequestMapping("updateContinen")
    public String updateContin(){

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
}
