package com.example.travelms.control;

import com.example.travelms.biz.CountryBiz;
import com.example.travelms.entity.Country;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
public class CountryControl {
    @Resource
    private CountryBiz countryBiz;

    @RequestMapping("country")
    @ResponseBody
    public Pages<Country> listCountry(Country country,Integer pageIndex,Integer pageSize){
        Pages<Country> pageCountry=countryBiz.listCountry(country, pageIndex,5);
        return pageCountry;
    }
    @RequestMapping("delCountry")
    @ResponseBody
    public int remove(Integer countryId){
        return countryBiz.remove(countryId);
    }
}
