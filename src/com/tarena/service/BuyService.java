package com.tarena.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.BuyerDao;
import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;
@Service//默认的Bean ID是buyService
public class BuyService {
	private BuyerDao buyerDao;
	@Resource(name="buyerDao")
	public void setBuyerDao(BuyerDao buyerDao) {
		this.buyerDao = buyerDao;
	}
	public BuyerDao getBuyerDao() {
		return buyerDao;
	}
	/*登录系统*/
	public Buyer login(String name,String pwd) throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("登陆参数不能为空");
		}
		Buyer buyer=buyerDao.findByName(name);
		if(buyer!=null&&pwd.equals(buyer.getPwd())){
			return buyer;
		}
		throw new NameOrPwdException("用户名或密码错误");
	}
	/*注册用户*/
	public Buyer register(String name, String pwd)throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("注册参数不能为空");
		}
		buyerDao.addBuyer(name,pwd);
		Buyer buyer=buyerDao.findByName(name);
		if(buyer!=null&&pwd.equals(buyer.getPwd())){
			return buyer;
		}
		throw new NameOrPwdException("注册用户未知错误");
	}
	/*获取商品表*/
	public List<Sellergoods> findGood() {
		List<Sellergoods> list=new ArrayList<Sellergoods>();
		list=buyerDao.findGood();
		return list;
	}
	/*获取某用户购物车信息*/
	public List<Cart> findCarts(String name) {
		List<Cart> cartlist=new ArrayList<Cart>();
		cartlist=buyerDao.findCarts(name);
		return cartlist;
	}
	/*加入购物车*/
	public void addCart(String name, String goodname, int numbers, int price) {
		buyerDao.addCart(name,goodname,numbers,price);
	}
	/*删除指定购物车商品*/
	public void delCart(int cartid) {
		buyerDao.delCart(cartid);
	}
	/*根据商品name获取商品信息*/
	public Sellergoods findGoodById(String goodname) {
		Sellergoods sellergoods=buyerDao.findGoodById(goodname);
		return sellergoods;
	}
	/*生成订单，删除购物车订单*/
	public void addList(BuyList buyList) {
		buyerDao.addList(buyList);
	}
	/*修改订单状态为已预约*/
	public void updateList(String name, String goodname,String date1) {
		buyerDao.update(name,goodname,date1);
	}
	/*查询用户订单*/
	public List<BuyList> findList(String name) {
		List<BuyList> list=buyerDao.findList(name);
		return list;
	}
	/*删除定单表*/
	public void delList(int listid) {
	buyerDao.delList(listid);
		
	}
	/*根据ID查找订单*/
	public BuyList findListById(int listid) {
		BuyList buyList=buyerDao.findListById(listid);
		return buyList;
	}
	/*根据ID修改订单状态*/
	public void updateList(int listid) {
		buyerDao.update(listid);
	}
	/*根据用户名获取用户表信息*/
	public Buyer findBuyer(String name) {
		Buyer buyer=buyerDao.findBuyer(name);
		return buyer;
	}
	/*修改用户密码*/
	public void updateBuyer(int id, String name, String pwd) {
		buyerDao.updateBuyer(id,name,pwd);
	}
	
}
