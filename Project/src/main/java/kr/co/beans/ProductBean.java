package kr.co.beans;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = -4274700572038677000L;

	private String productId; //��ǰ���̵�
	private String pname; //��ǰ�̸�
	private String desc; //��ǰ����
	private int pPrice; //��ǰ����
	private String pBrand; //��ǰ�귣��
	private String category; //��ǰī�װ�
	private int pStock; //��ǰ���
	private String filename; //��ǰ����


	public ProductBean() {
		super();
	}


	public ProductBean(String productId, String pname, int pPrice) {
		super();
		this.productId = productId;
		this.pname = pname;
		this.pPrice = pPrice;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getpPrice() {
		return pPrice;
	}


	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public String getpBrand() {
		return pBrand;
	}


	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getpStock() {
		return pStock;
	}


	public void setpStock(int pStock) {
		this.pStock = pStock;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}