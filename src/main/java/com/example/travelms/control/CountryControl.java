package com.example.travelms.control;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.biz.CountryBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CountryControl {
    @Resource
    private CountryBiz countryBiz;
    @Resource
    private ContinentBiz ContinentBiz;

    @RequestMapping("country")
    @ResponseBody
    public Pages<Country> pageCountry(Country country,Integer pageIndex,Integer pageSize){
        Pages<Country> pageCountry=countryBiz.listPageCountry(country, pageIndex,5);
        return pageCountry;
    }

    @RequestMapping("showAddCountry")
    public String showAddCountry(Model model){
        //地域
        model.addAttribute("conList",ContinentBiz.listContinent());
        return  "Country_add";
    }
    @RequestMapping(value = "addCountry", method = RequestMethod.POST)
    public String  addCountry(Model model, HttpSession session, Country country){
        if(countryBiz.add(country)) {
            return "redirect:country";
        }else {
            return "Country_add";
        }
    }

    //打开修改页面
    @RequestMapping("showUpdateCountry")
    public String show(Integer countryId,String countryName,Model model){
        model.addAttribute("countryId",countryId);
        model.addAttribute("countryName",countryName);
        return  "Country_edit";
    }

    @RequestMapping("updateCountry")
    @ResponseBody
    public int modify(Integer countryId,String countryName){
        Country country=new Country();
        country.setCountryId(countryId);
        country.setCountryName(countryName);
        return  countryBiz.modify(country);
    }
    @RequestMapping("deleteCountry")
    @ResponseBody
    public Pages deleteCountry(HttpServletRequest countryId, Country country){
        String[] cId = countryId.getParameterValues("countryId");
        Integer[] iId=new Integer [cId.length];
        for(int i=0;i<cId.length;i++) {
            iId[i] = Integer.parseInt(cId[i]);
        }
        Boolean b=countryBiz.removeAll(iId);
        Pages<Country> pagesCountry=new Pages<Country>();
        if(b==true){
            pagesCountry= pageCountry(country,1, 5);
        }
        return  pagesCountry;
    }
}
