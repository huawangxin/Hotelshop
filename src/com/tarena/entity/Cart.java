package com.tarena.entity;

import java.io.Serializable;

/*
 * 购物车实体类
 */
public class Cart implements Serializable{
	private int cartid;
	private String name;
	private String goodname;
	private int numbers;
	private int price;
	
	@Override
	public int hashCode() {
		return cartid;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(this instanceof Cart){
			Cart o=(Cart) obj;
			return this.cartid==o.cartid;
		}
		return true;
	}
	@Override
	public String toString() {
		return cartid + ", " + goodname + ", "+ name + 
		", " + numbers + "," + price ;
	}
	public Cart(int cartid, String name, String goodname, int numbers, int price) {
		super();
		this.cartid = cartid;
		this.name = name;
		this.goodname = goodname;
		this.numbers = numbers;
		this.price = price;
	}
	public Cart() {
		super();
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
