package com.example.travelms.control;

import com.example.travelms.biz.ContinentBiz;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Pages<Continent> continen(Continent con, Integer pageIndex, Integer pageSize) {
        Pages<Continent> pageContinent = continentBiz.listContinent(con, pageIndex,5);
        return pageContinent;
    }

    //打开修改页面
    @RequestMapping("updateContinen")
    public String updateContin(Integer continentId, String continentName, Model model) {
        model.addAttribute("continentId", continentId);
        model.addAttribute("continentName", continentName);
        return "continen_look";
    }

    @RequestMapping("updateContinen2")
    @ResponseBody
    public int updateContin2(Integer continentId, String continentName) {
        Continent continent = new Continent();
        continent.setContinentId(continentId);
        continent.setContinentName(continentName);
       /* continent.setHolidayId(2);*/
        return continentBiz.updateBycontId(continent);
    }

    //删除地域
    @RequestMapping("deleteContinen")
    @ResponseBody
    public Pages del(HttpServletRequest continentId, Continent con) {
        String[] tId = continentId.getParameterValues("continentId");
        Integer[] iId = new Integer[tId.length];
        for (int i = 0; i < tId.length; i++) {
            iId[i] = Integer.parseInt(tId[i]);
        }
        boolean b = continentBiz.delBycontId(iId);
        Pages<Continent> pageItem = new Pages<Continent>();
        if (b == true) {
            con.setContinentName(null);
            con.setContinentId(null);
            con.setHolidayId(null);
            pageItem = continentBiz.listContinent(con,1,5);
        }
        return pageItem;
    }

    //打开添加页面
    @RequestMapping("insertContinen")
    public String addOpen() {
        return "continen_add.html";
    }

    //添加数据后返回的页面
    @RequestMapping("insertContinen2")
    @ResponseBody
    public Integer addContinen(String continenName, Integer holidayId, HttpServletResponse response) throws IOException {
        Continent continent = new Continent();
        continent.setContinentName(continenName);
        continent.setHolidayId(holidayId);
        int num = continentBiz.addContinent(continent);
        return num;
    }
}
