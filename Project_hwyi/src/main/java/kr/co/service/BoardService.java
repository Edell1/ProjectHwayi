package kr.co.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.beans.ContentBean;
import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

   @Value("${path.upload}")
   private String path_upload;
   
   @Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
   
   @Autowired
   private BoardDao boardDao;
   
   @Resource(name="loginUserBean")
   private UserBean loginUserBean;

   @SuppressWarnings("unused")
   private String saveUploadFile(MultipartFile upload_file) {

      String file_name = System.currentTimeMillis() + "_"
            + FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "."
            + FilenameUtils.getExtension(upload_file.getOriginalFilename());

      try {// 경로와 파일네임
         upload_file.transferTo(new File(path_upload + "/" + file_name));
      } catch (Exception e) {
         e.printStackTrace();
      }

      return file_name;
      
   }// saveUploadFile

   public void addContentInfo(ContentBean writeContentBean) {

      System.out.println(writeContentBean.getContent_subject());
      System.out.println(writeContentBean.getContent_text());
      System.out.println(writeContentBean.getUpload_file().getSize());

      MultipartFile upload_file = writeContentBean.getUpload_file();

      if (upload_file.getSize() > 0) {
         String file_name = saveUploadFile(upload_file);
         System.out.println(file_name);
         writeContentBean.setContent_file(file_name); //오라클에 파일 이름 저장
      }
      
       writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
       
       boardDao.addContentInfo(writeContentBean);
       
   }
   
   public String getBoardInfoName(int board_info_idx) {
         return boardDao.getBoardInfoName(board_info_idx);
      }
   
   public List<ContentBean> getContentList(int board_info_idx, int page) {
	   
	   /*
		1->0
		2->10
		3->20
		*/
		
	   int start=(page-1)*page_listcnt;
	   RowBounds rowBounds=new RowBounds(start, page_listcnt);
      return boardDao.getContentList(board_info_idx, rowBounds);
   }
   ;
   public ContentBean getContentInfo(int content_idx) {
      return boardDao.getContentInfo(content_idx);
   }

   public void modifyContentInfo(ContentBean modifyContentBean) {
      
	   //이미지처리
      MultipartFile upload_file = modifyContentBean.getUpload_file();
      
      if (upload_file.getSize() > 0) {
         String file_name = saveUploadFile(upload_file);
         modifyContentBean.setContent_file(file_name);
      }
      
      boardDao.modifyContentInfo(modifyContentBean);
      
   }
   
   public void deleteContentInfo(int content_idx) {
	   boardDao.deleteContentInfo(content_idx);
   }
   
   public PageBean getContentCnt(int content_board_idx, int currentPage) {
	   int content_cnt = boardDao.getContentCnt(content_board_idx);
	   
	   PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
	   
	   return pageBean;
	   
   }

}
