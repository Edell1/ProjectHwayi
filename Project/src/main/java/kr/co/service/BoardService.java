package kr.co.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

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

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public void addContentInfo(ContentBean writeQnABean) {

		System.out.println(writeQnABean.getContent_subject());
		System.out.println(writeQnABean.getContent_title());

		writeQnABean.setCode(loginUserBean.getCode());

		boardDao.addContentInfo(writeQnABean);

	}

	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}

	public List<ContentBean> getContentList(int board_info_idx, int page) {

		/*
		 * 1->0 2->10 3->20
		 */

		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		return boardDao.getContentList(board_info_idx, rowBounds);
	};

	public ContentBean getContentInfo(int content_idx) {
		return boardDao.getContentInfo(content_idx);
	}

	public void modifyContentInfo(ContentBean modifyContentBean) {

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

	public List<ContentBean> getQnAList() {
		System.out.println("qna게시판 가져오기 다오~");
		return boardDao.getQnAList();
	}

	public ContentBean getQnAInfo(int content_idx) {

		return boardDao.getQnAInfo(content_idx);
	}

	public void deleteQnAInfo(int content_idx) {

		boardDao.deleteQnAInfo(content_idx);
	}

	public void updateQnAInfo( ContentBean writeQnABean) {
		
		boardDao.updateQnAInfo(writeQnABean);
		
	}

}