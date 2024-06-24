package kr.co.beans;

import java.util.Date;

public class OrderBean {

	/*
	 * orderID NUMBER PRIMARY KEY, code VARCHAR2(10) NOT NULL, item_count NUMBER NOT
	 * NULL, order_Date TIMESTAMP NOT NULL, price NUMBER, order_req VARCHAR(4000),
	 * order_stat VARCHAR(20) NOT NULL, order_addr VARCHAR(4000) NOT NULL,
	 * order_name VARCHAR(2000) NOT NULL, order_phone NUMBER NOT NULL
	 */

	private int orderID;
	private String code;
	private int item_count;
	private Date order_Date;
	private int price;
	private String order_req;
	private String order_stat;
	private String order_addr;
	private String order_addr2; // DB 추가해야됨
	private String order_name;
	private int order_phone;

	// 상품 정보받기용
	private String furnitureid;
	private String furniture_name;
	private int furniture_price;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrder_req() {
		return order_req;
	}

	public void setOrder_req(String order_req) {
		this.order_req = order_req;
	}

	public String getOrder_stat() {
		return order_stat;
	}

	public void setOrder_stat(String order_stat) {
		this.order_stat = order_stat;
	}

	public String getOrder_addr() {
		return order_addr;
	}

	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}

	public String getOrder_addr2() {
		return order_addr2;
	}

	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public int getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(int order_phone) {
		this.order_phone = order_phone;
	}

	public String getFurnitureid() {
		return furnitureid;
	}

	public void setFurnitureid(String furnitureid) {
		this.furnitureid = furnitureid;
	}

	public String getFurniture_name() {
		return furniture_name;
	}

	public void setFurniture_name(String furniture_name) {
		this.furniture_name = furniture_name;
	}

	public int getFurniture_price() {
		return furniture_price;
	}

	public void setFurniture_price(int furniture_price) {
		this.furniture_price = furniture_price;
	}

}