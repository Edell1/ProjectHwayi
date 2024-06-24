package kr.co.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.ContentBean;
import kr.co.mapper.BoardMapper;

@Repository
public class BoardDao {
   
   @Autowired
   private BoardMapper boardMapper;
   
   public void addContentInfo(ContentBean writeQnABean) {
      boardMapper.addContentInfo(writeQnABean);
   }
   
   public String getBoardInfoName(int board_info_idx) {
      return boardMapper.getBoardInfoName(board_info_idx);
   }
   
   public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
      return boardMapper.getContentList(board_info_idx, rowBounds);
   }
   
   public ContentBean getContentInfo(int content_idx) {
      return boardMapper.getContentInfo(content_idx);
   }
   
   public void modifyContentInfo(ContentBean modifyContentBean) {
      boardMapper.modifyContentInfo(modifyContentBean);
   }
   
   public void deleteContentInfo(int content_idx) {
      boardMapper.deleteContentInfo(content_idx);
   }
   
   public int getContentCnt(int content_board_idx) {
      return boardMapper.getContentCnt(content_board_idx);
   }

   public List<ContentBean> getQnAList() {
      return boardMapper.getQnAList();
   
   
   }

   public ContentBean getQnAInfo(int content_idx) {
      System.out.println("글내용불러오기 다오~");
      return boardMapper.getQnAInfo(content_idx);
   }

   public void deleteQnAInfo(int content_idx) {
      System.out.println("삭제하기 다오");
      boardMapper.deleteQnAInfo(content_idx);
   }

public void updateQnAInfo( ContentBean writeQnABean) {
			
	boardMapper.updateQnAInfo(writeQnABean);
	
}
}