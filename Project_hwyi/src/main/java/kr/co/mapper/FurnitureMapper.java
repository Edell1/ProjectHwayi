package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.FurnitureBean;

@Mapper
public interface FurnitureMapper {
   
   @Select("select furnitureid, furniture_name, code, furniture_price, furniture_cnt, tag from furniture")
   List<FurnitureBean> getFurnitureList();
   
   @Insert("insert into furniture(furnitureid, furniture_type, furniture_name, furniture_width, furniture_length, furniture_height, furniture_price, furniture_cnt, tag, add_date ) " +
           "values(#{furnitureid}, #{furniture_type}, #{furniture_name}, #{furniture_width}, #{furniture_length}, #{furniture_height}, #{furniture_price}, #{furniture_cnt}, #{tag}, sysdate)")
   void addFurnitureInfo(FurnitureBean addFurnitureBean);
   
   
}
 