package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.NoticeBean;
import kr.co.mapper.BoardMapper;
import kr.co.mapper.NoticeMapper;

@Repository
public class NoticeDao {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		System.out.println("DAO" + writeNoticeBean.getCode());
		noticeMapper.addNoticeInfo(writeNoticeBean);
	}
	
	public List<NoticeBean> getNoticeList(){
		return noticeMapper.getNoticeList();
	}
	
	public void deleteNoticeInfo(int postID) {
		noticeMapper.deleteNoticeInfo(postID);
	}

	public NoticeBean getNoticeInfo(int postID) {
		return noticeMapper.getNoticeInfo(postID);
	}
	
}