package com.tarena.dao;

import java.util.List;

import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;

//用户访问对象接口
public interface BuyerDao {
	//根据用户名查找数据库用户表
	public Buyer findByName(String name);
	/*注册新用户*/
	public void addBuyer(String name,String pwd);
	/*查找所有商品表*/
	public List<Sellergoods> findGood();
	/*查询某用户购物车表*/
	public List<Cart> findCarts(String name);
	/*加入购物车表*/
	public void addCart(String name, String goodname, int numbers, int price);
	/*删除指定ID购物车宝贝*/
	public void delCart(int cartid);
	/*根据商品name获取指定商品信息*/
	public Sellergoods findGoodById(String goodname);
	/*添加新的订单*/
	public void addList(BuyList buyList);
	/*修改订单状态为已预约*/
	public void update(String name, String goodname,String date1);
	/*查询用户订单*/
	public List<BuyList> findList(String name);
	/*删除定单表*/
	public void delList(int listid);
	/*根据ID查找订单*/
	public BuyList findListById(int listid);
	/*很据ID修改订单状态*/
	public void update(int listid);
	/*根据用户名获取用户表信息*/
	public Buyer findBuyer(String name);
	/*修改用户密码*/
	public void updateBuyer(int id, String name, String pwd);
	
}
