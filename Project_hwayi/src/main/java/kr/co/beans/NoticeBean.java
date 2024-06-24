package kr.co.beans;

public class NoticeBean {

	/*
	 * postID NUMBER PRIMARY KEY, code VARCHAR2(20) NOT NULL, noticeTitle
	 * VARCHAR2(2000) NOT NULL, content VARCHAR2(4000) NOT NULL, postDate TIMESTAMP
	 * NOT NULL, veiwCount NUMBER , setPIN CHAR(1)
	 */

	private int postID;
	private String code;
	private String noticeTitle;
	private String content;
	private String postDate;

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


}
