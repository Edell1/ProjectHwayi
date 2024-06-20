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

}
