package kr.co.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.NoticeBean;
import kr.co.beans.UserBean;
import kr.co.dao.NoticeDao;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		
		System.out.println("A" + writeNoticeBean.getNoticeTitle());
		System.out.println("B" + writeNoticeBean.getContent());
		System.out.println(writeNoticeBean.getCode());
		noticeDao.addNoticeInfo(writeNoticeBean);
	}


}