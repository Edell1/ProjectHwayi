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

	// �Ǹ����� ��ǰ���� ��� ��������
	@Select("select " + "furnitureid, " + "furniture_name, " + "furniture_price, "
			+ "TO_CHAR(add_date, 'YYYY/MM/DD') as furniture_date, " + "tag, " + "furniture_cnt, "
			+ "CASE  WHEN checked = 0 THEN '���οϷ�' "
			+ "when checked= 2  then '���ΰź�' Else '���δ��' END AS furniture_checked, "
			+ "CASE WHEN furniture_type = 'bd' THEN 'ħ��' " + "WHEN furniture_type = 'dk' THEN 'å��/���̺�' "
			+ "WHEN furniture_type = 'sf' THEN '����' " + "WHEN furniture_type = 'dr' THEN '������' "
			+ "WHEN furniture_type = 'ch' THEN '����' " + "WHEN furniture_type = 'sh' THEN '����' "
			+ "WHEN furniture_type = 'ca' THEN 'TV��/�Ž���' " + "WHEN furniture_type = 'bs' THEN 'å��' "
			+ "WHEN furniture_type = 'cl' THEN '����' " + "WHEN furniture_type = 'hg' THEN '���' "
			+ "WHEN furniture_type = 'pa' THEN '��Ƽ��' " + "WHEN furniture_type = 'mi' THEN '�ſ�' "
			+ "ELSE '��Ÿ' END AS furniture_type_text " + "FROM furniture " + "where code like #{seller_code} "
			+ "order by add_date desc")
	List<FurnitureBean> getFurnitureListfromSeller(String seller_code);

	// �Ǹ��� ��ǰ������ ��ǰ��� �������� ��������
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
