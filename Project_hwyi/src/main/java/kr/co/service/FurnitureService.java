package kr.co.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.beans.ContentBean;
import kr.co.beans.FurnitureBean;
import kr.co.beans.UserBean;
import kr.co.dao.FurnitureDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")//properties불러오기 = 사진저장되는 upload파일 경로 때문에
public class FurnitureService {
	
	/*
	 * //대표사진이 저장되는 경로 불러오기
	 * 
	 * @Value("${path.upload1}") //properties-option.properties에서 불러오기 private
	 * String path_upload1;
	 * 
	 * //상세페이지 사진이 저장되는 경로 불러오기
	 * 
	 * @Value("${path.upload2}") //properties-option.properties에서 불러오기 private
	 * String path_upload2;
	 */
	   
	   @Autowired
	   private FurnitureDao furnitureDao;
	   
		/*
		 * //로그인됐는지 확인하기
		 * 
		 * @Resource(name="loginUserBean") private UserBean loginUserBean;
		 * 
		 * 
		 * //대표사진 저장하기
		 * 
		 * @SuppressWarnings("unused") //@SuppressWarnings:경고뜨지말라고하는것 private String
		 * saveUploadFile1(MultipartFile upload_file1) {
		 * 
		 * String file_name1 = System.currentTimeMillis() + "_" +
		 * FilenameUtils.getBaseName(upload_file1.getOriginalFilename()) + "." +
		 * FilenameUtils.getExtension(upload_file1.getOriginalFilename());
		 * 
		 * try {// 경로와 파일네임 upload_file1.transferTo(new File(path_upload1 + "/" +
		 * file_name1)); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return file_name1; }
		 * 
		 * 
		 * 
		 * //상세페이지 사진 저장하기
		 * 
		 * @SuppressWarnings("unused") private String saveUploadFile2(MultipartFile
		 * upload_file2) {
		 * 
		 * String file_name2 = System.currentTimeMillis() + "_" +
		 * FilenameUtils.getBaseName(upload_file2.getOriginalFilename()) + "." +
		 * FilenameUtils.getExtension(upload_file2.getOriginalFilename());
		 * 
		 * try {// 경로와 파일네임 upload_file2.transferTo(new File(path_upload2 + "/" +
		 * file_name2)); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return file_name2; }
		 */
	
	/*
	 * public void addFurnitureInfo(ContentBean ) {
	 * 
	 * }
	 */

	public List<FurnitureBean> getFurnitureList() {
		System.out.println("Service");
		return furnitureDao.getFurnitureList();
	}
}
