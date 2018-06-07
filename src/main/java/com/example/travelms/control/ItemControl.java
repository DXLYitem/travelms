package com.example.travelms.control;
import com.example.travelms.biz.*;
import com.example.travelms.entity.Country;
import com.example.travelms.entity.Item;
import com.example.travelms.util.Pages;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

@Controller
public class ItemControl {
    @Resource
    private ItemBiz itemBiz;

    @Resource
    private HobbyService hobbyService;

    @Resource
    private TravelService travelService;

    @Resource
    private TrafficService trafficService;

    @Resource
    private StyleService styleService;

    @Resource
    private  BrandService brandService;

    @Resource
    private  ContinentBiz ContinentBiz;

    @Resource
    private CountryService countryService;


    @RequestMapping("item")
    @ResponseBody
    public Pages<Item> listItem(Item item,Integer pageIndex,Integer pageSize){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Pages<Item> pageItem=itemBiz.listItem(item, pageIndex,5);
        if(pageItem.getList().size()>0){
            for (int i=0;i<pageItem.getList().size();i++){
                String dateString= formatter.format(pageItem.getList().get(i).getStartTime());
                pageItem.getList().get(i).setDate(dateString);
            }
        }
        return pageItem;
    }




   @RequestMapping("updateItem")
    public String update(){
       System.out.println(111);
        return  "data_management_look";
    }

    @RequestMapping("showInsertItem")
    public String showInsertItem(Model model){

        //地域
        model.addAttribute("conList",ContinentBiz.listContinent());
        //偏好
       model.addAttribute("hobbyList",hobbyService.listHobby());
        //旅行主题
       model.addAttribute("travelList",travelService.listTravel());
       //交通工具
        model.addAttribute("trafficList",trafficService.listTraffic());
        //旅行方式
        model.addAttribute("styleList",styleService.listStyle());
        //酒店品牌
        model.addAttribute("brandList",brandService.listBrand());
        return  "Warning_management_add";
    }

    @RequestMapping(value = "insertItem", method = RequestMethod.POST)
    public String  insertItem(Model model, HttpSession session,Item item, @RequestParam("picFile") MultipartFile picFile) throws FileNotFoundException {
            if (!picFile.isEmpty()) {
                String uploadFilename = picFile.getOriginalFilename();
                String ext = FilenameUtils.getExtension(uploadFilename);
                if(picFile.getSize()>5000000) {
                    model.addAttribute("uploadError","文件大小超过限制(5MB)");
                    return "Warning_management_add";
                }
                if("jpg".equalsIgnoreCase(ext)
                        || "jpeg".equalsIgnoreCase(ext)
                        || "png".equalsIgnoreCase(ext)
                        || "pneg".equalsIgnoreCase(ext)) {
                    String p="E:\\旅游项目\\travel\\src\\main\\resources\\static\\images\\item\\";
                    String filename = "id" + System.currentTimeMillis() + (new Random().nextInt(10000)) + "." + ext;
                    File file = new File(p+filename);
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                    if(!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        out.write(picFile.getBytes());
                        item.setPicPath(filename);
                        out.flush();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        model.addAttribute("uploadError","文件上传出错");
                        return "Warning_management_add";
                    }

                } else {
                    model.addAttribute("uploadError","文件类型不符合要求(jpg,png)");
                    return "Warning_management_add";
                }
            }
        if(itemBiz.insertItem(item)) {
            return "redirect:item";
        }else {
            return "Warning_management_add";
       }

    }

    //ajax
    @RequestMapping("selectCountry")
    @ResponseBody
    public List<Country> list(Integer continentId){
        List<Country> list=  countryService.listCountry(continentId);
        return list;
    }


    //删除
    @RequestMapping("deleteItem")
    @ResponseBody
    public Pages deleteItem(HttpServletRequest itemId,Item item){
        String[] tId = itemId.getParameterValues("itemId");
        Integer[] iId=new Integer [tId.length];
        for(int i=0;i<tId.length;i++) {
            iId[i] = Integer.parseInt(tId[i]);
        }
        Boolean b=itemBiz.deleteItem(iId);
        Pages<Item> pageItem=new Pages<Item>();
        if(b==true){
            pageItem= listItem(item,1, 5);

        }
        return  pageItem;
    }
}
