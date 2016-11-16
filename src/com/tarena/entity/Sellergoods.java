package com.tarena.entity;

import java.io.Serializable;

public class Sellergoods implements Serializable{
	private int goodid;
	private String goodname;
	private int price;
	private String types;
	private String states;
	@Override
	public String toString() {
		return goodid+","+goodname+","+price+","+types+","+states;
	}
	@Override
	public int hashCode() {
		return goodid;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(this==obj){
			return true;
		}
		if(this==null){
			return false;
		}
		if(this instanceof Sellergoods){
			Sellergoods o=(Sellergoods) obj;
			return this.goodid==o.goodid;
		}
		return true;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public Sellergoods(int goodid, String goodname, int price, String types,
			String states) {
		super();
		this.goodid = goodid;
		this.goodname = goodname;
		this.price = price;
		this.types = types;
		this.states = states;
	}
	public Sellergoods() {
		super();
	}
	
	
	
}
