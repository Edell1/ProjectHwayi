package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.NoticeBean;
import kr.co.dao.NoticeDao;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		noticeDao.addNoticeInfo(writeNoticeBean);
	}


}
