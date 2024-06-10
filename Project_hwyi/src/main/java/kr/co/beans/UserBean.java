package kr.co.beans;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	private String user_code;

	@Size(min = 2, max = 4)
	@Pattern(regexp = "[°¡-ÆR]*")
	private String user_name;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*") // ¿µ¾î ¶Ç´Â ¼ýÀÚ¸¸ ÀÔ·Â ÀÚÁÖ ¾²ÀÌ´Â Á¤±Ô½Ä(Regular Expression)
	private String user_id;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;

	@Size(min = 1)
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	private String user_email;

	@Size(min = 1)
	@Pattern(regexp = "^[0-9]+$")
	private String user_tel;

	@Size(min = 1)
	private String user_add1;

	@Size(min = 1)
	private String user_add2;

	@Size(min = 1)
	private String seller_num;

	@Size(min = 1)
	@Pattern(regexp = "^[0-9]+$")
	private String seller_tel;

	@Size(min = 1)
	private String seller_add1;

	@Size(min = 1)
	private String seller_add2;

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getSeller_add1() {
		return seller_add1;
	}

	public void setSeller_add1(String seller_add1) {
		this.seller_add1 = seller_add1;
	}

	public String getSeller_add2() {
		return seller_add2;
	}

	public void setSeller_add2(String seller_add2) {
		this.seller_add2 = seller_add2;
	}

	public String getSeller_tel() {
		return seller_tel;
	}

	public void setSeller_tel(String seller_tel) {
		this.seller_tel = seller_tel;
	}

	public String getSeller_num() {
		return seller_num;
	}

	public void setSeller_num(String seller_num) {
		this.seller_num = seller_num;
	}

	public String getUser_add1() {
		return user_add1;
	}

	public void setUser_add1(String user_add1) {
		this.user_add1 = user_add1;
	}

	public String getUser_add2() {
		return user_add2;
	}

	public void setUser_add2(String user_add2) {
		this.user_add2 = user_add2;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	private boolean userIdExist;

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

}