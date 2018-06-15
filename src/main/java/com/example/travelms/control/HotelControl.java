package com.example.travelms.control;

import com.example.travelms.biz.CountryBiz;
import com.example.travelms.biz.HotelBiz;
import com.example.travelms.entity.Hotel;
import com.example.travelms.util.Pages;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

@Controller
public class HotelControl {
    @Resource
    private HotelBiz hotelBiz;
    @Resource
    private CountryBiz countryBiz;


    @RequestMapping("hotel")
    @ResponseBody
    public Pages<Hotel> listHotel(Hotel hotel, Integer pageIndex, Integer pageSize){
        Pages<Hotel> pageCountry=hotelBiz.listHotel(hotel, pageIndex,3);
        return pageCountry;
    }
    //删除地域
    @RequestMapping("deleteHotel")
    @ResponseBody
    public Pages del(HttpServletRequest hotelId, Hotel hotel) {
        String[] tId = hotelId.getParameterValues("hotelId");
        Integer[] iId = new Integer[tId.length];
        for (int i = 0; i < tId.length; i++) {
            iId[i] = Integer.parseInt(tId[i]);
        }
        boolean b = hotelBiz.delByhotelId(iId);
        Pages<Hotel> pageItem = new Pages<Hotel>();
        if (b == true) {
            hotel.setHotelId(null);
            hotel.setHotelName(null);
            hotel.setPicPath(null);
            hotel.setAddress(null);
            hotel.setBreakfast(null);
            hotel.setCountryId(null);
            hotel.setDinner(null);
            hotel.setHotelDesc(null);
            hotel.setHotelIntro(null);
            hotel.setStar(null);
            hotel.setRoomType(null);
            hotel.setLunch(null);
            pageItem = hotelBiz.listHotel(hotel,1,3);
        }
        return pageItem;
    }
    //打开修改页面
    @RequestMapping("showUpdateHotel")
    public String showUpdateHotel(Hotel hotel, Model model) {
        model.addAttribute("hotelId", hotel.getHotelId());
        model.addAttribute("hotelName",hotel.getHotelName());
        model.addAttribute("star",hotel.getStar());
        model.addAttribute("roomType",hotel.getRoomType());
        model.addAttribute("address",hotel.getAddress());
        model.addAttribute("countryName",hotel.getCountryName());

        return "Hotel_update";
    }
    @RequestMapping("updateHotel")
    @ResponseBody
    public int updateHotel(Hotel hotel){
        Hotel h=new Hotel();
        h.setHotelId(hotel.getHotelId());
        h.setAddress(hotel.getAddress());
        h.setRoomType(hotel.getRoomType());
        h.setStar(hotel.getStar());
        h.setHotelName(hotel.getHotelName());
        h.setCountryName(hotel.getCountryName());
        return hotelBiz.updateByHotelId(h);
    }
    @RequestMapping("showInsertHotel")
    public String showInsertHotel(Model model){
        //地区
        model.addAttribute("country",countryBiz.countryList());
        return "Hotel_add";
    }
    @RequestMapping(value = "insertHotel", method = RequestMethod.POST)
    public String insertHotel(Model model, HttpSession session, Hotel hotel, @RequestParam("picFile") MultipartFile picFile[]) throws FileNotFoundException {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < picFile.length; i++) {
        if (!picFile[i].isEmpty()) {
            String uploadFilename = picFile[i].getOriginalFilename();
            String ext = FilenameUtils.getExtension(uploadFilename);
            if (picFile[i].getSize() > 5000000) {
                model.addAttribute("uploadError", "文件大小超过限制(5MB)");
                return "Warning_management_add";
            }
            if ("jpg".equalsIgnoreCase(ext)
                    || "jpeg".equalsIgnoreCase(ext)
                    || "png".equalsIgnoreCase(ext)
                    || "pneg".equalsIgnoreCase(ext)) {
                String p = "E:\\旅游项目\\travel\\Protect1\\src\\main\\resources\\static\\item\\";
                String filename = "id" + System.currentTimeMillis() + (new Random().nextInt(10000)) + "." + ext;
                File file = new File(p + filename);
                BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(file));

                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    sb.append(filename+" ");

                    out.write(picFile[i].getBytes());

                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("uploadError", "文件上传出错");
                    return "Hotel_add";
                }

            } else {
                model.addAttribute("uploadError", "文件类型不符合要求(jpg,png)");
                return "Hotel_add";
            }
        }
    }
        System.out.println(sb);
        hotel.setPicPath(sb.toString());
     int num=hotelBiz.addHotel(hotel);
       if(num>0){
           return "redirect:hotel";
       }else {
           return "Hotel_add";
       }
    }
}
