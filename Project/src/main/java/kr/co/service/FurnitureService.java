package kr.co.service;

import java.io.File;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.beans.FurnitureBean;
import kr.co.beans.UserBean;
import kr.co.dao.FurnitureDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties") // properties불러오기 = 사진저장되는 upload파일 경로 때문에
public class FurnitureService {

//   // 대표사진이 저장되는 경로 불러오기
//   @Value("${path.upload1}") // properties-option.properties에서 불러오기 private
//   String path_upload1;
//
//   // 상세페이지 사진이 저장되는 경로 불러오기
//   @Value("${path.upload2}") // properties-option.properties에서 불러오기 private
//   String path_upload2;

	@Autowired
	private FurnitureDao furnitureDao;

	// 로그인됐는지 확인하기
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

//   // 대표사진 저장하기
//   @SuppressWarnings("unused") //@SuppressWarnings:경고뜨지말라고하는것 private String
//    private String saveUploadFile1(MultipartFile upload_file1) {
//     
//     String file_name1 = System.currentTimeMillis() + "_" +
//    FilenameUtils.getBaseName(upload_file1.getOriginalFilename()) + "." +
//     FilenameUtils.getExtension(upload_file1.getOriginalFilename());
//     
//     try { //경로와 파일네임
//      upload_file1.transferTo(new File(path_upload1 + "/" + file_name1));
//   } catch (Exception e) {
//      e.printStackTrace();
//   }
//     
//
//   return file_name1;
//   }
//
//
//   // 상세페이지 저장하기
//   @SuppressWarnings("unused") //@SuppressWarnings:경고뜨지말라고하는것 private String
//    private String saveUploadFile2(MultipartFile upload_file2) {
//     
//     String file_name2 = System.currentTimeMillis() + "_" +
//    FilenameUtils.getBaseName(upload_file2.getOriginalFilename()) + "." +
//     FilenameUtils.getExtension(upload_file2.getOriginalFilename());
//     
//     try { //경로와 파일네임
//        upload_file2.transferTo(new File(path_upload2 + "/" + file_name2));
//   } catch (Exception e) {
//      e.printStackTrace();
//   }
//     
//
//   return file_name2;
//   }

	public void addFurnitureInfo(FurnitureBean addFurnitureBean) {

		Random random = new Random();
		int num = random.nextInt(1000);
		System.out.println(num);

		String ll = "";
		System.out.println(addFurnitureBean.getFurniture_name());
		System.out.println(addFurnitureBean.getFurniture_price());
		System.out.println(addFurnitureBean.getFurniture_cnt());
		System.out.println(addFurnitureBean.getFurniture_width());
		System.out.println(addFurnitureBean.getFurniture_height());
		System.out.println(addFurnitureBean.getFurniture_length());
		System.out.println(addFurnitureBean.getFurniture_type());
		System.out.println(addFurnitureBean.getFurniture_color());
		System.out.println(addFurnitureBean.getCode());
		System.out.println(addFurnitureBean.getUpload_file1().getSize());
		System.out.println(addFurnitureBean.getUpload_file2().getSize());
//      System.out.println(path_upload1);

//      MultipartFile upload_file1= addFurnitureBean.getUpload_file1();
//      MultipartFile upload_file2= addFurnitureBean.getUpload_file2();
//      
//      if(upload_file1.getSize()>0) {
//         String file_name1 = saveUploadFile1(upload_file1);
//         System.out.println(file_name1);
//         addFurnitureBean.setFurniture_img1(file_name1);
//      }
//      
//      if(upload_file2.getSize()>0) {
//         String file_name2 = saveUploadFile2(upload_file2);
//         System.out.println(file_name2);
//         addFurnitureBean.setFurniture_img2(file_name2);
//      }

		// 상품코드 만들기
		if (addFurnitureBean.getFurniture_color().equals("화이트")) {
			ll = addFurnitureBean.getFurniture_type() + "01";
		} else if (addFurnitureBean.getFurniture_color().equals("그레이")) {
			ll = addFurnitureBean.getFurniture_type() + "02";
		} else if (addFurnitureBean.getFurniture_color().equals("블랙")) {
			ll = addFurnitureBean.getFurniture_type() + "03";
		} else if (addFurnitureBean.getFurniture_color().equals("베이지")) {
			ll = addFurnitureBean.getFurniture_type() + "04";
		} else if (addFurnitureBean.getFurniture_color().equals("브라운")) {
			ll = addFurnitureBean.getFurniture_type() + "05";
		} else if (addFurnitureBean.getFurniture_color().equals("실버")) {
			ll = addFurnitureBean.getFurniture_type() + "06";
		} else if (addFurnitureBean.getFurniture_color().equals("골드")) {
			ll = addFurnitureBean.getFurniture_type() + "07";
		} else if (addFurnitureBean.getFurniture_color().equals("레드")) {
			ll = addFurnitureBean.getFurniture_type() + "08";
		} else if (addFurnitureBean.getFurniture_color().equals("옐로우")) {
			ll = addFurnitureBean.getFurniture_type() + "09";
		} else if (addFurnitureBean.getFurniture_color().equals("그린")) {
			ll = addFurnitureBean.getFurniture_type() + "10";
		} else if (addFurnitureBean.getFurniture_color().equals("오렌지")) {
			ll = addFurnitureBean.getFurniture_type() + "11";
		} else if (addFurnitureBean.getFurniture_color().equals("블루")) {
			ll = addFurnitureBean.getFurniture_type() + "12";
		} else if (addFurnitureBean.getFurniture_color().equals("네이비")) {
			ll = addFurnitureBean.getFurniture_type() + "13";
		} else if (addFurnitureBean.getFurniture_color().equals("핑크")) {
			ll = addFurnitureBean.getFurniture_type() + "14";
		} else if (addFurnitureBean.getFurniture_color().equals("투명")) {
			ll = addFurnitureBean.getFurniture_type() + "15";
		} else if (addFurnitureBean.getFurniture_color().equals("기타")) {
			ll = addFurnitureBean.getFurniture_type() + "16";
		}

		System.out.println(ll);

		if (addFurnitureBean.getFurniture_mat().equals("원목")) {
			ll += "01" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("가공목")) {
			ll += "02" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("대리석")) {
			ll += "03" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("세라믹")) {
			ll += "04" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("유리")) {
			ll += "05" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("철재")) {
			ll += "06" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("플라스틱")) {
			ll += "07" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("가죽")) {
			ll += "08" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("흙,돌")) {
			ll += "09" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("아쿠아텍스")) {
			ll += "10" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("패브릭")) {
			ll += "11" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("라탄")) {
			ll += "12" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("종이")) {
			ll += "13" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("거울")) {
			ll += "14" + num;
		}

		System.out.println(ll);

		addFurnitureBean.setFurnitureid(ll);

		addFurnitureBean.setTag(addFurnitureBean.getFurniture_color() + ", " + addFurnitureBean.getFurniture_mat());

		addFurnitureBean.setCode(loginUserBean.getCode());

		furnitureDao.addFurnitureInfo(addFurnitureBean);

	}

	public List<FurnitureBean> getFurnitureList() {
		System.out.println("Service");
		return furnitureDao.getFurnitureList();
	}

	public FurnitureBean selectFurnitureById(String furnitureid) {
		FurnitureBean furnitureBean = furnitureDao.selectFurnitureById(furnitureid);
		return furnitureBean;
	}

	public void modifyFurnitureInfo(FurnitureBean modifyFurnitureBean) {
		furnitureDao.modifyFurnitureInfo(modifyFurnitureBean);
	}

	public void grantFurnitureInfoByAdmin(FurnitureBean modifyFurnitureBean) {
		furnitureDao.grantFurnitureInfoByAdmin(modifyFurnitureBean);
	}

	// 가구 타입에 따른 목록가져오기
	public List<FurnitureBean> getFurnitureListFromType(String furnitureType) {

		return furnitureDao.getFurnitureListFromType(furnitureType);
	}

	// 관리자가 승인한 가구들 가져오기
	public List<FurnitureBean> getCheckedFurnitureList() {
		System.out.println("CheckService");
		return furnitureDao.getCheckedFurnitureList();
	}

	// 필터를 모두 적용했을 때 가구들 가져오기
	public List<FurnitureBean> getFurnitureListFromFilterAll(String furnitureType, String color, String brand,
			int width, int length, int height) {
		System.out.println("FilterService");
		return furnitureDao.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
	}

}