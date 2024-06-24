package kr.co.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrdetailBean {

	/*
	 * orderKey NUMBER PRIMARY KEY, orderID NUMBER NOT NULL, furnitureid
	 * VARCHAR(20), price NUMBER NOT NULL, count NUMBER NOT NULL
	 */

	private int orderKey;
	private int orderID;
	private String furnitureid;
	private int price;
	private int count;

	public int getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(int orderKey) {
		this.orderKey = orderKey;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getFurnitureid() {
		return furnitureid;
	}

	public void setFurnitureid(String furnitureid) {
		this.furnitureid = furnitureid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
