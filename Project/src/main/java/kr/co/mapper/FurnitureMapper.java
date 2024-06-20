package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.beans.FurnitureBean;

@Mapper
public interface FurnitureMapper {

	@Select("select * from furniture")
	List<FurnitureBean> getFurnitureList();

	@Insert("insert into furniture(code, furnitureid, furniture_type, furniture_name, furniture_width, furniture_length, furniture_height, furniture_price, furniture_cnt, tag, add_date ) "
			+ "values(#{code}, #{furnitureid}, #{furniture_type}, #{furniture_name}, #{furniture_width}, #{furniture_length}, #{furniture_height}, #{furniture_price}, #{furniture_cnt}, #{tag}, sysdate)")
	void addFurnitureInfo(FurnitureBean addFurnitureBean);

	// 아이디로 상품 정보 확인
	@Select("SELECT f.*, s.* from furniture f join store s on f.code = s.code WHERE furnitureid = #{furnitureid}")
	FurnitureBean selectFurnitureById(String furnitureid);

	// 상품 정보 수정
	@Update("update furniture set furniture_name=#{furniture_name}, furniture_price=#{furniture_price}, furniture_cnt=#{furniture_cnt}, tag=#{tag}"
			+ "where furnitureid=#{furnitureid}")
	void modifyFurnitureInfo(FurnitureBean modifyFurnitureBean);

	// 관리자권한 상품 승인
	@Update("update furniture set checked=#{checked} where furnitureid=#{furnitureid}")
	void grantFurnitureInfoByAdmin(FurnitureBean modifyFurnitureBean);

	// 가구 타입에 따른 가구 리스트 가져오기
	@Select("select * from furniture where checked = 0 and furniture_type = #{furnitureType}")
	List<FurnitureBean> getFurnitureListFromType(String furnitureType);

	// 관리자가 승인한 가구들 가져오기
	@Select("select * from furniture where checked = 0 ")
	List<FurnitureBean> getCheckedFurnitureList();

}
