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
@PropertySource("/WEB-INF/properties/option.properties") // properties�ҷ����� = ��������Ǵ� upload���� ��� ������
public class FurnitureService {

//   // ��ǥ������ ����Ǵ� ��� �ҷ�����
//   @Value("${path.upload1}") // properties-option.properties���� �ҷ����� private
//   String path_upload1;
//
//   // �������� ������ ����Ǵ� ��� �ҷ�����
//   @Value("${path.upload2}") // properties-option.properties���� �ҷ����� private
//   String path_upload2;

	@Autowired
	private FurnitureDao furnitureDao;

	// �α��εƴ��� Ȯ���ϱ�
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

//   // ��ǥ���� �����ϱ�
//   @SuppressWarnings("unused") //@SuppressWarnings:������������ϴ°� private String
//    private String saveUploadFile1(MultipartFile upload_file1) {
//     
//     String file_name1 = System.currentTimeMillis() + "_" +
//    FilenameUtils.getBaseName(upload_file1.getOriginalFilename()) + "." +
//     FilenameUtils.getExtension(upload_file1.getOriginalFilename());
//     
//     try { //��ο� ���ϳ���
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
//   // �������� �����ϱ�
//   @SuppressWarnings("unused") //@SuppressWarnings:������������ϴ°� private String
//    private String saveUploadFile2(MultipartFile upload_file2) {
//     
//     String file_name2 = System.currentTimeMillis() + "_" +
//    FilenameUtils.getBaseName(upload_file2.getOriginalFilename()) + "." +
//     FilenameUtils.getExtension(upload_file2.getOriginalFilename());
//     
//     try { //��ο� ���ϳ���
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

		// ��ǰ�ڵ� �����
		if (addFurnitureBean.getFurniture_color().equals("ȭ��Ʈ")) {
			ll = addFurnitureBean.getFurniture_type() + "01";
		} else if (addFurnitureBean.getFurniture_color().equals("�׷���")) {
			ll = addFurnitureBean.getFurniture_type() + "02";
		} else if (addFurnitureBean.getFurniture_color().equals("��")) {
			ll = addFurnitureBean.getFurniture_type() + "03";
		} else if (addFurnitureBean.getFurniture_color().equals("������")) {
			ll = addFurnitureBean.getFurniture_type() + "04";
		} else if (addFurnitureBean.getFurniture_color().equals("����")) {
			ll = addFurnitureBean.getFurniture_type() + "05";
		} else if (addFurnitureBean.getFurniture_color().equals("�ǹ�")) {
			ll = addFurnitureBean.getFurniture_type() + "06";
		} else if (addFurnitureBean.getFurniture_color().equals("���")) {
			ll = addFurnitureBean.getFurniture_type() + "07";
		} else if (addFurnitureBean.getFurniture_color().equals("����")) {
			ll = addFurnitureBean.getFurniture_type() + "08";
		} else if (addFurnitureBean.getFurniture_color().equals("���ο�")) {
			ll = addFurnitureBean.getFurniture_type() + "09";
		} else if (addFurnitureBean.getFurniture_color().equals("�׸�")) {
			ll = addFurnitureBean.getFurniture_type() + "10";
		} else if (addFurnitureBean.getFurniture_color().equals("������")) {
			ll = addFurnitureBean.getFurniture_type() + "11";
		} else if (addFurnitureBean.getFurniture_color().equals("���")) {
			ll = addFurnitureBean.getFurniture_type() + "12";
		} else if (addFurnitureBean.getFurniture_color().equals("���̺�")) {
			ll = addFurnitureBean.getFurniture_type() + "13";
		} else if (addFurnitureBean.getFurniture_color().equals("��ũ")) {
			ll = addFurnitureBean.getFurniture_type() + "14";
		} else if (addFurnitureBean.getFurniture_color().equals("����")) {
			ll = addFurnitureBean.getFurniture_type() + "15";
		} else if (addFurnitureBean.getFurniture_color().equals("��Ÿ")) {
			ll = addFurnitureBean.getFurniture_type() + "16";
		}

		System.out.println(ll);

		if (addFurnitureBean.getFurniture_mat().equals("����")) {
			ll += "01" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("������")) {
			ll += "02" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("�븮��")) {
			ll += "03" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("�����")) {
			ll += "04" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("����")) {
			ll += "05" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("ö��")) {
			ll += "06" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("�ö�ƽ")) {
			ll += "07" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("����")) {
			ll += "08" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("��,��")) {
			ll += "09" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("������ؽ�")) {
			ll += "10" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("�к긯")) {
			ll += "11" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("��ź")) {
			ll += "12" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("����")) {
			ll += "13" + num;
		} else if (addFurnitureBean.getFurniture_mat().equals("�ſ�")) {
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

	// ���� Ÿ�Կ� ���� ��ϰ�������
	public List<FurnitureBean> getFurnitureListFromType(String furnitureType) {

		return furnitureDao.getFurnitureListFromType(furnitureType);
	}

	// �����ڰ� ������ ������ ��������
	public List<FurnitureBean> getCheckedFurnitureList() {
		System.out.println("CheckService");
		return furnitureDao.getCheckedFurnitureList();
	}

	// ���͸� ��� �������� �� ������ ��������
	public List<FurnitureBean> getFurnitureListFromFilterAll(String furnitureType, String color, String brand,
			int width, int length, int height) {
		System.out.println("FilterService");
		return furnitureDao.getFurnitureListFromFilterAll(furnitureType, color, brand, width, length, height);
	}

}