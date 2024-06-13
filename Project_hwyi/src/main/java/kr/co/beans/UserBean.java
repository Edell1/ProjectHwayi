package kr.co.beans;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	private String CODE;

	private int user_idx;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*") // ¿µ¾î ¶Ç´Â ¼ýÀÚ¸¸ ÀÔ·Â ÀÚÁÖ ¾²ÀÌ´Â Á¤±Ô½Ä(Regular Expression)
	private String ID;

	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String PW;
	
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String PW2;

	@Size(min = 2, max = 4)
	@Pattern(regexp = "[°¡-ÆR]*")
	private String Name;

	@Size(min = 1)
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
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

	private boolean userLogin;

	private boolean userIdExist;

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

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

}