package com.example.travelms.biz;
import com.example.travelms.entity.Continent;
import com.example.travelms.util.Pages;

import java.util.List;

/**
 * 地域表Biz
 */
public interface ContinentBiz {
  Pages<Continent> listContinent(Continent continent, Integer pageIndex, Integer pageSize);
  int updateBycontId(Continent continent);
  boolean delBycontId(Integer [] continentId);
  int addContinent(Continent continent);
  List<Continent>listExcelController();


  List<Continent> listContinent();
}
