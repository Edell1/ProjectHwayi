package kr.co.beans;

<<<<<<< HEAD
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
=======
>>>>>>> refs/remotes/origin/heumE
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

<<<<<<< HEAD
	private String CODE;
=======
	private int user_idx;
>>>>>>> refs/remotes/origin/heumE

<<<<<<< HEAD
	private int user_idx;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*") // ¿µ¾î ¶Ç´Â ¼ýÀÚ¸¸ ÀÔ·Â ÀÚÁÖ ¾²ÀÌ´Â Á¤±Ô½Ä(Regular Expression)
	private String ID;
=======
	private String code;

	@Size(min = 2, max = 4)
	@Pattern(regexp = "[ê°€-íž£]*")
	private String name;
>>>>>>> refs/remotes/origin/heumE

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
<<<<<<< HEAD
	private String PW;
	
=======
	private String id;

>>>>>>> refs/remotes/origin/heumE
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
<<<<<<< HEAD
	private String PW2;

	@Size(min = 2, max = 4)
	@Pattern(regexp = "[°¡-ÆR]*")
	private String Name;
=======
	private String pw;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String pw2;
>>>>>>> refs/remotes/origin/heumE

	@Size(min = 1)
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
<<<<<<< HEAD
	private String Mail;
	
	@NotNull
    @Min(1)
	private int Phone;

	@Size(min = 1)
	private String Address;

	@Size(min = 1)
	private String Address2;

	private String Favarite;

	@NotNull
    @Min(1)
	private long strcode;

	@Size(min = 1)
	private String straddress;

	@Size(min = 1)
	private String straddress2;

	@NotNull
    @Min(1)
	private int strtel;
=======
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
>>>>>>> refs/remotes/origin/heumE

	private boolean userLogin;
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/heumE
	private boolean userIdExist;

<<<<<<< HEAD
	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}
=======
	private String userRole;

	public UserBean() {
		this.userIdExist = false;
		this.userLogin = false;
	}

	// Getters and Setters for all fields, including userRole
>>>>>>> refs/remotes/origin/heumE

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

<<<<<<< HEAD
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String PW) {
		this.PW = PW;
	}

	public String getPW2() {
		return PW2;
	}

	public void setPW2(String PW2) {
		this.PW2 = PW2;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String Mail) {
		this.Mail = Mail;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int Phone) {
		this.Phone = Phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}

	public String getFavarite() {
		return Favarite;
	}

	public void setFavarite(String Favarite) {
		this.Favarite = Favarite;
	}

	public long getStrcode() {
		return strcode;
	}

	public void setStrcode(long strcode) {
		this.strcode = strcode;
	}

	public String getStraddress() {
		return straddress;
	}

	public void setstraddress(String straddress) {
		this.straddress = straddress;
	}

	public String getStraddress2() {
		return straddress2;
	}

	public void setstraddress2(String straddress2) {
		this.straddress2 = straddress2;
	}

	public int getStrtel() {
		return strtel;
	}

	public void setStrtel(int strtel) {
		this.strtel = strtel;
=======
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
>>>>>>> refs/remotes/origin/heumE
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

<<<<<<< HEAD
=======
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
>>>>>>> refs/remotes/origin/heumE
}