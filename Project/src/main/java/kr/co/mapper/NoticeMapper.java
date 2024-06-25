package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import kr.co.beans.ContentBean;
import kr.co.beans.NoticeBean;

public interface NoticeMapper {

	// �۾���
	@Insert("insert into notice " + "values (notice_seq.nextval, 'admin', #{noticeTitle}, #{content}, sysdate, 0)")
	void addNoticeInfo(NoticeBean writeNoticeBean);

	// �۸��
	@Select("select * " + "from notice " + "order by postID desc")
	List<NoticeBean> getNoticeList();

	// �����ϱ�
	@Delete("delete from notice where postID = #{postID}")
	void deleteNoticeInfo(int postID);

	// ������
	@Select("select * from notice where postID = #{postID}")
	NoticeBean getNoticeInfo(int postID);

}