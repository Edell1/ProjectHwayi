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
@PropertySource("/WEB-INF/properties/option.properties")//properties�ҷ����� = ��������Ǵ� upload���� ��� ������
public class FurnitureService {
	
	/*
	 * //��ǥ������ ����Ǵ� ��� �ҷ�����
	 * 
	 * @Value("${path.upload1}") //properties-option.properties���� �ҷ����� private
	 * String path_upload1;
	 * 
	 * //�������� ������ ����Ǵ� ��� �ҷ�����
	 * 
	 * @Value("${path.upload2}") //properties-option.properties���� �ҷ����� private
	 * String path_upload2;
	 */
	   
	   @Autowired
	   private FurnitureDao furnitureDao;
	   
		/*
		 * //�α��εƴ��� Ȯ���ϱ�
		 * 
		 * @Resource(name="loginUserBean") private UserBean loginUserBean;
		 * 
		 * 
		 * //��ǥ���� �����ϱ�
		 * 
		 * @SuppressWarnings("unused") //@SuppressWarnings:������������ϴ°� private String
		 * saveUploadFile1(MultipartFile upload_file1) {
		 * 
		 * String file_name1 = System.currentTimeMillis() + "_" +
		 * FilenameUtils.getBaseName(upload_file1.getOriginalFilename()) + "." +
		 * FilenameUtils.getExtension(upload_file1.getOriginalFilename());
		 * 
		 * try {// ��ο� ���ϳ��� upload_file1.transferTo(new File(path_upload1 + "/" +
		 * file_name1)); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return file_name1; }
		 * 
		 * 
		 * 
		 * //�������� ���� �����ϱ�
		 * 
		 * @SuppressWarnings("unused") private String saveUploadFile2(MultipartFile
		 * upload_file2) {
		 * 
		 * String file_name2 = System.currentTimeMillis() + "_" +
		 * FilenameUtils.getBaseName(upload_file2.getOriginalFilename()) + "." +
		 * FilenameUtils.getExtension(upload_file2.getOriginalFilename());
		 * 
		 * try {// ��ο� ���ϳ��� upload_file2.transferTo(new File(path_upload2 + "/" +
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
