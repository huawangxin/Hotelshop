package com.tarena.entity;

import java.io.Serializable;

public class Seller implements Serializable{
	private int id;
	private String name;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Seller(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public Seller() {
		super();
	}
	@Override
	public String toString() {
		return id + ", " + name + "," + pwd;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(this==null){
			return false;
		}
		if(this instanceof Seller){
			Seller o=(Seller) obj;
			return this.id==o.id;
		}
		return true;
	}
}
