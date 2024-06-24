package kr.co.mapper;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.beans.ContentBean;

public interface BoardMapper {
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)

	// 글쓰기
	@Insert("insert into qna(content_idx, code, content_title, content_subject, add_date, q_checked, secret) "
			+ "values (qna_seq.nextval, #{code}, #{content_title}, #{content_subject}, " + "sysdate,1, #{secret}) ")
	void addContentInfo(ContentBean writeQnABean);

	// 게시판 이름
	@Select("select board_info_name " + "from board_info_table " + "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);

	// 글목록
	@Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name, "
			+ "       to_char(a1.content_date, 'YYYY-MM-DD') as content_date " + "from content_table a1, user_table a2 "
			+ "where a1.content_writer_idx = a2.user_idx " + "      and a1.content_board_idx = #{board_info_idx} "
			+ "order by a1.content_idx desc")
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);

	// 상세정보
	@Select("select a2.user_name as content_writer_name, "
			+ "       to_char(a1.content_date, 'YYYY-MM-DD') as content_date, "
			+ "       a1.content_subject, a1.content_text, a1.content_file, a1.content_writer_idx "
			+ "from content_table a1, user_table a2 " + "where a1.content_writer_idx = a2.user_idx "
			+ "      and content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);

	// 수정하기
	@Update("update content_table " + "set content_subject = #{content_subject}, content_text = #{content_text}, "
			+ "content_file = #{content_file, jdbcType=VARCHAR} " + "where content_idx = #{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);

	// 삭제하기
	@Delete("delete from qna where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);

	// 해당게시판의 전체글의 수 가져오기
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
	int getContentCnt(int content_board_idx);

	// QnA게시판 글목록
	@Select("select content_idx, content_title, content_subject, m.name as name, to_char(add_date,'yyyy-mm-dd') as add_date, "
			+ "COALESCE(NULLIF(to_char(answer_date, 'yyyy-mm-dd'), ''), '-') as answer_date, "
			+ "case when q_checked = 1 then '답변대기' else '답변완료' end as q_checked_text, secret, q.code as code  "
			+ "from qna q, member m " + "where q.code=m.code " + "order by content_idx desc")
	List<ContentBean> getQnAList();

	// QnA글 내용 읽기
	@Select("select q.*, m.name as name from qna q, member m where content_idx = #{content_idx} and q.code=m.code")
	ContentBean getQnAInfo(int content_idx);

	// QnA글 삭제하기
	@Delete("delete qna where content_idx = #{content_idx}")
	void deleteQnAInfo(int content_idx);

	//Q&A답글 달기
	@Update("update qna set acontent = #{acontent}, answer_date = sysdate, " +
	"q_checked = 0 where content_idx = #{content_idx}")
	void updateQnAInfo( ContentBean writeQnABean);

}