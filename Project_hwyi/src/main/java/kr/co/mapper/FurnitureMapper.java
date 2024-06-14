package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.FurnitureBean;

@Mapper
public interface FurnitureMapper {
	
	@Select("select furnitureid, furniture_name, code, furniture_price, furniture_cnt, tag, brand from furniture")
	List<FurnitureBean> getFurnitureList();
}
 