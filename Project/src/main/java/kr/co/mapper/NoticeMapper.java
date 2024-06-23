package kr.co.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.beans.NoticeBean;

public interface NoticeMapper {
	
	//±Û¾²±â
	@Insert("insert into notice " +
			"values (notice_seq.nextval, 'admin', #{noticeTitle}, #{content}, sysdate, 0)")
	void addNoticeInfo(NoticeBean writeNoticeBean);

}
