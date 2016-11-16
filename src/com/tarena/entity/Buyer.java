package com.tarena.entity;

import java.io.Serializable;


/*
 * 用户表实体类
 * id number(20),
name varchar2(50),
pwd varchar2(50),
 */
public class Buyer implements Serializable{
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
	public Buyer(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public Buyer() {
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
		if(this instanceof Buyer){
			Buyer o=(Buyer) obj;
			return this.id==o.id;
		}
		return true;
	}
}
