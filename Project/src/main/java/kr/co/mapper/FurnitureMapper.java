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

	// ���̵�� ��ǰ ���� Ȯ��
	@Select("SELECT f.*, s.* from furniture f join store s on f.code = s.code WHERE furnitureid = #{furnitureid}")
	FurnitureBean selectFurnitureById(String furnitureid);

	// ��ǰ ���� ����
	@Update("update furniture set furniture_name=#{furniture_name}, furniture_price=#{furniture_price}, furniture_cnt=#{furniture_cnt}, tag=#{tag}"
			+ "where furnitureid=#{furnitureid}")
	void modifyFurnitureInfo(FurnitureBean modifyFurnitureBean);

	// �����ڱ��� ��ǰ ����
	@Update("update furniture set checked=#{checked} where furnitureid=#{furnitureid}")
	void grantFurnitureInfoByAdmin(FurnitureBean modifyFurnitureBean);

	// ���� Ÿ�Կ� ���� ���� ����Ʈ ��������
	@Select("select * from furniture where checked = 0 and furniture_type = #{furnitureType}")
	List<FurnitureBean> getFurnitureListFromType(String furnitureType);

	// �����ڰ� ������ ������ ��������
	@Select("select * from furniture where checked = 0 ")
	List<FurnitureBean> getCheckedFurnitureList();

	// ī�װ� �� ���������� ������ ��������
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} " + "and code like #{brand} "
			+ "and trim(substr(tag, 1, instr(tag, ',') - 1)) like #{color}")
	List<FurnitureBean> getFurnitureListFromFilterAll(@Param("furnitureType") String furnitureType,
			@Param("color") String color, @Param("brand") String brand, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// �������͸�
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} "
			+ "and trim(substr(tag, 1, instr(tag, ',') - 1)) like #{color}")
	List<FurnitureBean> getFurnitureListFromFilterColor(String furnitureType, String color, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// �귣�����͸�
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} " + "and code like #{brand} ")
	List<FurnitureBean> getFurnitureListFromFilterbrand(String furnitureType, String brand, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// ������ ���͸�
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_width < #{width} "
			+ "and furniture_length < #{length} " + "and furniture_height < #{height} ")
	List<FurnitureBean> getFurnitureListFromFilterSize(String furnitureType, @Param("width") int width,
			@Param("length") int length, @Param("height") int height);

	// ��ǰ�˻� ���
	@Select("select * from furniture where " + "checked = 0 " + "and furniture_name like '%' || #{keyword} || '%'")
	List<FurnitureBean> searchProducts(String keyword);
}