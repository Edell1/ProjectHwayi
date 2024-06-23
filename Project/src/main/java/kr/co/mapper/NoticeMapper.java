package kr.co.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.beans.NoticeBean;

public interface NoticeMapper {
	
	//±Û¾²±â
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addNoticeInfo(NoticeBean writeNoticeBean);

}
