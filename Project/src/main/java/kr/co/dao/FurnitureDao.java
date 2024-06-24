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

	// 가구 카테고리를 선택했을 때 가구 가져오기
	public List<FurnitureBean> getFurnitureListFromType(String furnitureType) {

		return furnitureMapper.getFurnitureListFromType(furnitureType);
	}

	// 관리자 승인이 된 가구 가져오기
	public List<FurnitureBean> getCheckedFurnitureList() {
		System.out.println("checkdao");
		return furnitureMapper.getCheckedFurnitureList();
	}

	// 가구 필터링 하기
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
//         System.out.println("브랜드만 선택함");
//         return furnitureMapper.getFurnitureListFromFilterbrand(furnitureType, brand, width, length, height);
//      }else if(brand.equals("noFilter")) {
//         System.out.println("색상만 선택함");
//         return furnitureMapper.getFurnitureListFromFilterColor(furnitureType, color, width, length, height);
//      }else 
//         System.out.println("둘 다 선택함");
//      return furnitureMapper.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
//   }

		if (color != "noFilter" && brand != "noFilter") {
			System.out.println("둘 다 선택함");
			return furnitureMapper.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
		}
		if (brand == "noFilter") {
			System.out.println("색상만 선택함");
			return furnitureMapper.getFurnitureListFromFilterColor(furnitureType, color, width, length, height);
		}
		if (color == "noFilter") {
			System.out.println("브랜드만 선택함");
			return furnitureMapper.getFurnitureListFromFilterbrand(furnitureType, brand, width, length, height);
		}
		return furnitureMapper.getFurnitureListFromFilterSize(furnitureType, width, length, height);

	}

	public List<FurnitureBean> searchProducts(String keyword) {
		System.out.println("검색 dao가동~!");
		return furnitureMapper.searchProducts(keyword);
	}

	public List<FurnitureBean> getFurnitureListfromSeller(String seller_code) {
		System.out.println("판매자 상품 가져오기 다오에용");
		return furnitureMapper.getFurnitureListfromSeller(seller_code);
	}

	public FurnitureBean selectProductById(String furnitureid) {
		System.out.println("판매자별 상품 상세정보 가져오기 다오~!@");
		return furnitureMapper.selectProductById(furnitureid);
	}

	public void modifyProduct(FurnitureBean modifyProductBean) {
		System.out.println("가구 수정하기 다오!");
		furnitureMapper.modifyProduct(modifyProductBean);

	}

}