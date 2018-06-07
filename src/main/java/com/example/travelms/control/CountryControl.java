package com.example.travelms.control;

import com.example.travelms.biz.CountryBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.io.IOException;

@Controller
public class CountryControl {
    @Resource
    private CountryBiz countryBiz;

    @RequestMapping("country")
    @ResponseBody
    public Pages<Country> pageCountry(Country country,Integer pageIndex,Integer pageSize){
        Pages<Country> pageCountry=countryBiz.listPageCountry(country, pageIndex,5);
        return pageCountry;
    }
    @RequestMapping("delCountry")
    @ResponseBody
    public int remove(Integer countryId){
        return countryBiz.remove(countryId);
    }

    @RequestMapping("addCountry")
    public String Open(){
        return "Country_add.html";
    }
    //添加数据后返回的页面
    @RequestMapping("insertCountry2")
    @ResponseBody
    public Integer add(String countryName, Integer continentId)throws IOException {
        Country country=new Country();
        country.setCountryName(countryName);
        country.setContinentId(continentId);
        Integer num=countryBiz.add(country);
        return num;
    }
}
