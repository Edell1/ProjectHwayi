package kr.co.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	private int user_idx;

	private String code;

	@Size(min = 2, max = 4)
	@Pattern(regexp = "[가-힣]*")
	private String name;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String id;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String pw;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String pw2;

	@Size(min = 1)
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	private String mail;

	@Size(min = 1)
	@Pattern(regexp = "^[0-9]+$")
	private String phone;

	@Size(min = 1)
	private String address;

	@Size(min = 1)
	private String address2;

	@Size(min = 1)
	private String strcode;

	@Size(min = 1)
	@Pattern(regexp = "^[0-9]+$")
	private String strtel;

	@Size(min = 1)
	private String straddress;

	@Size(min = 1)
	private String straddress2;

	@Size(min = 1)
	private String brand;

	private String favarite;

	private boolean userLogin;
	private boolean userIdExist;

	private String userRole;

	public UserBean() {
		this.userIdExist = false;
		this.userLogin = false;
	}

	// Getters and Setters for all fields, including userRole

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStrcode() {
		return strcode;
	}

	public void setStrcode(String strcode) {
		this.strcode = strcode;
	}

	public String getStrtel() {
		return strtel;
	}

	public void setStrtel(String strtel) {
		this.strtel = strtel;
	}

	public String getStraddress() {
		return straddress;
	}

	public void setStraddress(String straddress) {
		this.straddress = straddress;
	}

	public String getStraddress2() {
		return straddress2;
	}

	public void setStraddress2(String straddress2) {
		this.straddress2 = straddress2;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFavarite() {
		return favarite;
	}

	public void setFavarite(String favarite) {
		this.favarite = favarite;
	}

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}