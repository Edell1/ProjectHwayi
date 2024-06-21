package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.FurnitureBean;
import kr.co.beans.UserBean;
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

	public FurnitureBean selectFurnitureById(String furnitureid) {
		return furnitureMapper.selectFurnitureById(furnitureid);
	}

	public void modifyFurnitureInfo(FurnitureBean modifyFurnitureBean) {
		furnitureMapper.modifyFurnitureInfo(modifyFurnitureBean);
	}

	public void grantFurnitureInfoByAdmin(FurnitureBean modifyFurnitureBean) {
		furnitureMapper.grantFurnitureInfoByAdmin(modifyFurnitureBean);
	}

	// ���� ī�װ��� �������� �� ���� ��������
	public List<FurnitureBean> getFurnitureListFromType(String furnitureType) {

		return furnitureMapper.getFurnitureListFromType(furnitureType);
	}

	// ������ ������ �� ���� ��������
	public List<FurnitureBean> getCheckedFurnitureList() {
		System.out.println("checkdao");
		return furnitureMapper.getCheckedFurnitureList();
	}

	// ���� ���͸� �ϱ�
	public List<FurnitureBean> getFurnitureListFromFilterAll(String furnitureType, String color, String brand,
			int width, int length, int height) {
		System.out.println(furnitureType);
		System.out.println(color);
		System.out.println(brand);
		System.out.println(width);
		System.out.println(length);
		System.out.println(height);

//      if(color.equals("noFilter") && brand.equals("noFilter")) {
//         return furnitureMapper.getFurnitureListFromFilterSize(furnitureType, width, length, height);
//      }else if(color.equals("noFilter")) {
//         System.out.println("�귣�常 ������");
//         return furnitureMapper.getFurnitureListFromFilterbrand(furnitureType, brand, width, length, height);
//      }else if(brand.equals("noFilter")) {
//         System.out.println("���� ������");
//         return furnitureMapper.getFurnitureListFromFilterColor(furnitureType, color, width, length, height);
//      }else 
//         System.out.println("�� �� ������");
//      return furnitureMapper.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
//   }

		if (color != "noFilter" && brand != "noFilter") {
			System.out.println("�� �� ������");
			return furnitureMapper.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
		}
		if (brand == "noFilter") {
			System.out.println("���� ������");
			return furnitureMapper.getFurnitureListFromFilterColor(furnitureType, color, width, length, height);
		}
		if (color == "noFilter") {
			System.out.println("�귣�常 ������");
			return furnitureMapper.getFurnitureListFromFilterbrand(furnitureType, brand, width, length, height);
		}
		return furnitureMapper.getFurnitureListFromFilterSize(furnitureType, width, length, height);

	}

	public List<FurnitureBean> searchProducts(String keyword) {
		System.out.println("�˻� dao����~!");
		return furnitureMapper.searchProducts(keyword);
	}

}