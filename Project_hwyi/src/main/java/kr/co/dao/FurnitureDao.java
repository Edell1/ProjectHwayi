package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.FurnitureBean;
import kr.co.mapper.FurnitureMapper;

@Repository
public class FurnitureDao {
   
   @Autowired
   private FurnitureMapper furnitureMapper;

   public List<FurnitureBean> getFurnitureList() {
      System.out.println("DAO");
      return furnitureMapper.getFurnitureList();
   }
   
   public void addFurnitureInfo(FurnitureBean addFurnitureBean) {
      System.out.println(addFurnitureBean.getFurniture_name());
      furnitureMapper.addFurnitureInfo(addFurnitureBean);
   }
   

}