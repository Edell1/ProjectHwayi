package kr.co.dao;

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
		noticeMapper.addNoticeInfo(writeNoticeBean);
	}

}
