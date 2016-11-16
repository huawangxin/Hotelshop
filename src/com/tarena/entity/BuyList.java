package com.tarena.entity;

import java.io.Serializable;
/*订单实体类*/
public class BuyList implements Serializable{
	private int listid;
	private String goodname;
	private int numbers;
	private int prices;
	private String name;
	private String phone;
	private String date1;
	private String date2;
	private String states;
	@Override
	public int hashCode() {
		return listid;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(this instanceof BuyList){
			BuyList o=(BuyList) obj;
			return this.listid==o.listid;
		}
		return true;
	}
	@Override
	public String toString() {
		return numbers+","+date1 + "," + date2 + ","+ "," + listid + "," + name
				+ ", " + phone + ", " + prices + ","+ states;
	}
	public BuyList() {
		super();
	}
	
	public BuyList(int listid, String goodname, int numbers, int prices,
			String name, String phone, String date1, String date2, String states) {
		super();
		this.listid = listid;
		this.goodname = goodname;
		this.numbers = numbers;
		this.prices = prices;
		this.name = name;
		this.phone = phone;
		this.date1 = date1;
		this.date2 = date2;
		this.states = states;
	}
	public int getListid() {
		return listid;
	}
	public void setListid(int listid) {
		this.listid = listid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
}
