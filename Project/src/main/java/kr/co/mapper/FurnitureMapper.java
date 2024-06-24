package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

	// 카테고리 및 필터했을때 가구들 가져오기
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} " + "and code like #{brand} "
			+ "and trim(substr(tag, 1, instr(tag, ',') - 1)) like #{color}")
	List<FurnitureBean> getFurnitureListFromFilterAll(@Param("furnitureType") String furnitureType,
			@Param("color") String color, @Param("brand") String brand, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// 색상필터링
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} "
			+ "and trim(substr(tag, 1, instr(tag, ',') - 1)) like #{color}")
	List<FurnitureBean> getFurnitureListFromFilterColor(String furnitureType, String color, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// 브랜드필터링
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} " + "and code like #{brand} ")
	List<FurnitureBean> getFurnitureListFromFilterbrand(String furnitureType, String brand, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// 사이즈 필터링
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} ")
	List<FurnitureBean> getFurnitureListFromFilterSize(String furnitureType, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// 상품검색 결과
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_name like '%' || #{keyword} || '%'")
	List<FurnitureBean> searchProducts(String keyword);

	// 판매자의 상품관리 목록 가져오기
	@Select("select " + "furnitureid, " + "furniture_name, " + "furniture_price, "
			+ "TO_CHAR(add_date, 'YYYY/MM/DD') as furniture_date, " + "tag, " + "furniture_cnt, "
			+ "CASE  WHEN checked = 0 THEN '승인완료' "
			+ "when checked= 2  then '승인거부' Else '승인대기' END AS furniture_checked, "
			+ "CASE WHEN furniture_type = 'bd' THEN '침대' " + "WHEN furniture_type = 'dk' THEN '책상/테이블' "
			+ "WHEN furniture_type = 'sf' THEN '소파' " + "WHEN furniture_type = 'dr' THEN '서랍장' "
			+ "WHEN furniture_type = 'ch' THEN '의자' " + "WHEN furniture_type = 'sh' THEN '선반' "
			+ "WHEN furniture_type = 'ca' THEN 'TV장/거실장' " + "WHEN furniture_type = 'bs' THEN '책장' "
			+ "WHEN furniture_type = 'cl' THEN '옷장' " + "WHEN furniture_type = 'hg' THEN '행거' "
			+ "WHEN furniture_type = 'pa' THEN '파티션' " + "WHEN furniture_type = 'mi' THEN '거울' "
			+ "ELSE '기타' END AS furniture_type_text " + "FROM furniture " + "where code like #{seller_code} "
			+ "order by add_date desc")
	List<FurnitureBean> getFurnitureListfromSeller(String seller_code);

	// 판매자 상품관리용 상품목록 세부정보 가져오기
	@Select("select furnitureid, " + "code, " + "furniture_type, " + "furniture_name, " + "furniture_width, "
			+ "furniture_length, " + "furniture_height, " + "furniture_price, " + "furniture_cnt, "
			+ "SUBSTR(tag, INSTR(tag, ',', 1, 2) + 1) AS tag, " + "TO_CHAR(add_date, 'YYYY/MM/DD') as furniture_date , "
			+ "furniture_img1, " + "furniture_img2, " + "trim(substr(tag, 1, instr(tag, ',') - 1)) as furniture_color, "
			+ "trim(SUBSTR(tag, INSTR(tag, ',', 1, 1) + 1, INSTR(tag, ',', 1, 2) - INSTR(tag, ',', 1, 1) - 1)) as furniture_mat "
			+ "from furniture " + "where furnitureid like #{furnitureid}")
	FurnitureBean selectProductById(String furnitureid);

	@Update("update furniture set " + "furniture_name = #{furniture_name}, " + "furniture_price=#{furniture_price}, "
			+ "furniture_cnt=#{furniture_cnt}, " + "tag= #{tag}, " + "checked=1 where furnitureid=#{furnitureid} ")
	void modifyProduct(FurnitureBean modifyProductBean);
}